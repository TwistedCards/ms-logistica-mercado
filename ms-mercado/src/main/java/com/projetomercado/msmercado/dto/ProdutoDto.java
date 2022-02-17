package com.projetomercado.msmercado.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

	@Column(unique = true)
	private String nome;
	
	@Column(unique = true)
	private String codigo;
	private BigDecimal qtde;
	
	public ProdutoDto() {
	}

	public ProdutoDto(String nome, String codigo, BigDecimal qtde) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.qtde = qtde;
	}
}
