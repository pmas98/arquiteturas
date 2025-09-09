package com.unifor.arquiteturas.repository;

import com.unifor.arquiteturas.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    
    List<Stock> findByProdutoId(Long produtoId);
}
