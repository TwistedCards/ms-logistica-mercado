package com.projetomercado.mspedido.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {

	private String codigo;
	private BigDecimal qtde;
	
	public PedidoRequest() {
	}

	public PedidoRequest(String codigo, BigDecimal qtde) {
		super();
		this.codigo = codigo;
		this.qtde = qtde;
	}
}
