package com.unifor.arquiteturas.services;

import com.unifor.arquiteturas.models.Stock;

import java.util.List;

public interface StockInterface {
    
    public Stock createStock(Stock stock);
    public List<Stock> getAllStocks();
    public Stock getStockById(Long id);
    public Stock updateStock(Long id, Stock stock);
    public boolean deleteStock(Long id);
    public List<Stock> getStockByProdutoId(Long produtoId);
}
