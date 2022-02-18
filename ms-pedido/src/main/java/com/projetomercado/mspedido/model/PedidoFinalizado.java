package com.projetomercado.mspedido.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoFinalizado implements Serializable{
	private static final long serialVersionUID = 1L;

	private long id;
	private BigDecimal valorTotal;
	private List<ProdutoFinalizado> produtosFinalizados = new ArrayList<>();
	
	public PedidoFinalizado(long id, BigDecimal valorTotal) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
	}
	
	public PedidoFinalizado() {
	}

}
