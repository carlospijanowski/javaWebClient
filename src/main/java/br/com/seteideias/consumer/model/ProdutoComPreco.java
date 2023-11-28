package br.com.seteideias.consumer.model;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

public record ProdutoComPreco(Long codigo, String nome, BigDecimal preco) {
}
