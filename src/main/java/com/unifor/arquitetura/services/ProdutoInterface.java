package com.unifor.arquiteturas.services;

import com.unifor.arquiteturas.models.Produto;

import java.util.List;

public interface ProdutoInterface {
    
    public Produto createProduto(Produto produto);
    public List<Produto> getAllProdutos();
    public Produto getProdutoById(Long id);
    public Produto updateProduto(Long id, Produto produto);
    public boolean deleteProduto(Long id);
}
