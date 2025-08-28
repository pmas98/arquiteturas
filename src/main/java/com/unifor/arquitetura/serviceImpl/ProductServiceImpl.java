package com.unifor.arquitetura.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifor.arquitetura.models.Product;
import com.unifor.arquitetura.repository.ProductRepository;
import com.unifor.arquitetura.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product createProduct(Product product) {
        if (productRepository.existsByName(product.getName())) {
            throw new RuntimeException("Product já existe");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Preço deve ser maior que zero");
        }
        if (product.getStockQuantity() < 0) {
            throw new RuntimeException("Estoque não pode ser negativo");
        }
        return productRepository.save(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        
        return productRepository.save(existingProduct);
    }
    
    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
    
    @Override
    public List<Product> getProductsInStock() {
        return productRepository.findByStockQuantityGreaterThan(0);
    }
    
    @Override
    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        if (minPrice.compareTo(BigDecimal.ZERO) < 0 || maxPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Price range values must be non-negative");
        }
        if (minPrice.compareTo(maxPrice) > 0) {
            throw new RuntimeException("Minimum price cannot be greater than maximum price");
        }
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    
    @Override
    public Product updateStockQuantity(Long id, Integer newQuantity) {
        if (newQuantity < 0) {
            throw new RuntimeException("Stock quantity cannot be negative");
        }
        
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        product.setStockQuantity(newQuantity);
        return productRepository.save(product);
    }
}
