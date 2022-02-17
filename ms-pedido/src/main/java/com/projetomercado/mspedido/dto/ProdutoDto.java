package com.projetomercado.mspedido.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

	private String nomeProduto;
	private String codigo;
	private BigDecimal qtde;
	private BigDecimal valor;
	
	public ProdutoDto() {
	}

	public ProdutoDto(String nomeProduto, String codigo, BigDecimal qtde, BigDecimal valor) {
		super();
		this.nomeProduto = nomeProduto;
		this.codigo = codigo;
		this.qtde = qtde;
		this.valor = valor;
	}
}
