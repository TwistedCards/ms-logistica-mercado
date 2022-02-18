package com.projetomercado.mspedido.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mercado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private String cnpj;
	private List<Produto> produtos = new ArrayList<>();

	public Mercado() {
	}
	
	public Mercado(long id, String nome, String cnpj, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.produtos = produtos;
	}
	
	public Mercado(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
}
