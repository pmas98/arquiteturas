package com.unifor.arquiteturas.serviceImpl;

import com.unifor.arquiteturas.models.Produto;
import com.unifor.arquiteturas.repository.ProdutoRepository;
import com.unifor.arquiteturas.services.ProdutoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoInterface {
    
    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto createProduto(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    @Override
    public Produto getProdutoById(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }

    @Override
    public Produto updateProduto(Long id, Produto produto) {
        if (repository.existsById(id)) {
            produto.setId(id);
            return repository.save(produto);
        }
        return null;
    }

    @Override
    public boolean deleteProduto(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
