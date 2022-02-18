package com.projetomercado.mspedido.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoFinalizado{
	
	private String nome;
	@JsonIgnore
	private PedidoFinalizado pedidoFinalizado;

	public ProdutoFinalizado() {
	}
	
}
