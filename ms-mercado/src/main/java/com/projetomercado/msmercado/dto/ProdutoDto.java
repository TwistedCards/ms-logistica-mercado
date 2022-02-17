package com.projetomercado.msmercado.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.projetomercado.msmercado.model.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

	private List<Produto> produtos = new ArrayList<>();
	private BigDecimal valorTotal;
	
	public ProdutoDto() {
	}

	public ProdutoDto(List<Produto> produtos, BigDecimal valorTotal) {
		super();
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}
	
}
