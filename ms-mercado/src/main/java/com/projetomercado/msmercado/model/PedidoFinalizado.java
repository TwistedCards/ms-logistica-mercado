package com.projetomercado.msmercado.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido_finalizado")
public class PedidoFinalizado implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private BigDecimal valorTotal;
	
	@OneToMany(mappedBy = "pedidoFinalizado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ProdutoFinalizado> produtosFinalizados = new ArrayList<>();
	
	public PedidoFinalizado(long id, BigDecimal valorTotal) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
	}
	
	public PedidoFinalizado() {
	}

}
