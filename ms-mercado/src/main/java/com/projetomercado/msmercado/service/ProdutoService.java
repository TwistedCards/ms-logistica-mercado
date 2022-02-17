package com.projetomercado.msmercado.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projetomercado.msmercado.dto.ProdutoDto;
import com.projetomercado.msmercado.model.Mercado;
import com.projetomercado.msmercado.model.Pedido;
import com.projetomercado.msmercado.model.Produto;

@Service
public class ProdutoService {
	private BigDecimal valorTotalCompra;
	
	public ProdutoDto processandoPedido(List<Pedido> pedidos, Mercado mercado) {
		List<Produto> produtosComprados = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		valorTotalCompra = BigDecimal.ZERO;
		
		pedidos.forEach(produtoEscolhido -> {
			mercado.getProdutos().forEach(produtoMercado -> {
				if(produtoEscolhido.getCodigo().equals(produtoMercado.getCodigo())) {
					valorTotalCompra = valorTotalCompra.add(produtoMercado.getPreco().multiply(produtoEscolhido.getQtde()));
					produtosComprados.add(produtoMercado);
				}
			});
		});
		
		produtoDto.getProdutos().addAll(produtosComprados);
		produtoDto.setValorTotal(valorTotalCompra);
		
		return produtoDto;
	}
	
	
}
