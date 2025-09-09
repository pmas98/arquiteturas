package com.unifor.arquiteturas.serviceImpl;

import com.unifor.arquiteturas.models.Stock;
import com.unifor.arquiteturas.repository.StockRepository;
import com.unifor.arquiteturas.services.StockInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockInterface {
    
    @Autowired
    private StockRepository repository;

    @Override
    public Stock createStock(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        Optional<Stock> stock = repository.findById(id);
        return stock.orElse(null);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        if (repository.existsById(id)) {
            stock.setId(id);
            return repository.save(stock);
        }
        return null;
    }

    @Override
    public boolean deleteStock(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Stock> getStockByProdutoId(Long produtoId) {
        return repository.findByProdutoId(produtoId);
    }

}
