package com.unifor.arquitetura.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.unifor.arquitetura.models.Product;

public interface ProductService {
    
    Product createProduct(Product product);
    
    List<Product> getAllProducts();
    
    Optional<Product> getProductById(Long id);
    
    Product updateProduct(Long id, Product product);
    
    void deleteProduct(Long id);
    
    List<Product> getProductsInStock();
    
    List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
        
    Product updateStockQuantity(Long id, Integer newQuantity);
}
