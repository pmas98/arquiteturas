package com.unifor.arquiteturas.dto;

import com.unifor.arquiteturas.models.Stock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    private Long id;
    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private Integer quantidadeMinima;
    private String localizacao;
    private String observacoes;

    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.produtoId = stock.getProduto().getId();
        this.produtoNome = stock.getProduto().getNome();
        this.quantidade = stock.getQuantidade();
        this.quantidadeMinima = stock.getQuantidadeMinima();
        this.localizacao = stock.getLocalizacao();
        this.observacoes = stock.getObservacoes();
    }
}
