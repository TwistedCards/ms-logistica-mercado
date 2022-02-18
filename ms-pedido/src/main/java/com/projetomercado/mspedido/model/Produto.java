package com.projetomercado.mspedido.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	private long id;
	private String nome;
	private String codigo;
	private BigDecimal preco;
//	private Mercado mercado;

	public Produto() {
	}
	
	public Produto(long id, String nome, String codigo, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}
	
}
