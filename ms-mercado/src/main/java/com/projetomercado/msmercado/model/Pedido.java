package com.projetomercado.msmercado.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {

	private String codigo;
	private BigDecimal qtde;
	
	public Pedido() {
	}

	public Pedido(String codigo, BigDecimal qtde) {
		super();
		this.codigo = codigo;
		this.qtde = qtde;
	}
}
