package com.projetomercado.mspedido.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String nomeProduto;
	private String codigo;
	private BigDecimal qtde;
	private BigDecimal valorTotal;
	
	public Pedido() {
	}

	public Pedido(long id, String nomeProduto, String codigo, BigDecimal qtde) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.codigo = codigo;
		this.qtde = qtde;
	}
	
}
