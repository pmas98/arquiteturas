package com.unifor.arquiteturas.models;

import lombok.Data;

@Data
public class Stock {
    private Long id;
    private Produto produto;
    private Integer quantidade;
    private Integer quantidadeMinima;
    private String localizacao;
    private String observacoes;
}
