package com.projetomercado.msmercado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomercado.msmercado.dto.ProdutoDto;
import com.projetomercado.msmercado.model.PedidoFinalizado;
import com.projetomercado.msmercado.model.ProdutoFinalizado;
import com.projetomercado.msmercado.repository.PedidoFinalizadoRepository;

@Service
public class PedidoFinalizadoService {
	
	@Autowired
	private PedidoFinalizadoRepository repository;
	
	public PedidoFinalizado setPedidoFinal(ProdutoDto produtoDto) {
		var pedidoFinalizado = new PedidoFinalizado();
		List<ProdutoFinalizado> listProdutoFinalizado = new ArrayList<>();
		
		pedidoFinalizado.setValorTotal(produtoDto.getValorTotal());
		
		produtoDto.getProdutos().forEach(produtoComprado -> {
			var produtoFinalizado = new ProdutoFinalizado();
			
			produtoFinalizado.setNome(produtoComprado.getNome());
			produtoFinalizado.setPedidoFinalizado(pedidoFinalizado);
			listProdutoFinalizado.add(produtoFinalizado);
		});
		
		pedidoFinalizado.getProdutosFinalizados().addAll(listProdutoFinalizado);
		return repository.save(pedidoFinalizado);
	}
	
}
