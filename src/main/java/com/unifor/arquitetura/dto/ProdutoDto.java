package com.unifor.arquiteturas.dto;

import com.unifor.arquiteturas.models.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
    }
}
