package com.unifor.arquiteturas.models;

import lombok.Data;

@Data
public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}