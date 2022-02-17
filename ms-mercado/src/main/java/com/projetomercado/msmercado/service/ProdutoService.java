package com.projetomercado.msmercado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projetomercado.msmercado.dto.ProdutoDto;
import com.projetomercado.msmercado.model.Mercado;
import com.projetomercado.msmercado.model.Produto;

@Service
public class ProdutoService {

	public List<Produto> processandoPedido(List<ProdutoDto> produtos, Mercado mercado) {
		List<Produto> produtosComprados = new ArrayList<>();
		
		produtos.forEach(produtoEscolhido -> {
			mercado.getProdutos().forEach(produtoMercado -> {
				if(produtoEscolhido.getCodigo().equals(produtoMercado.getCodigo())) {
					produtosComprados.add(produtoMercado);
				}
			});
		});
		
		return produtosComprados;
	}
	
	
}
