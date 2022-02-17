package com.projetomercado.mspedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomercado.mspedido.dto.ProdutoDto;
import com.projetomercado.mspedido.feignclients.MercadoFeignClient;
import com.projetomercado.mspedido.model.Mercado;
import com.projetomercado.mspedido.model.Pedido;
import com.projetomercado.mspedido.model.Produto;

@Service
public class PedidoService {

	@Autowired
	private MercadoFeignClient mercadoFeignClient;
	
	public Mercado getMercado(long mercadoId) {
		Mercado mercado = mercadoFeignClient.findByCnpj(mercadoId).getBody();
		return mercado;
	}
	
	public List<Pedido> fazendoPedido(long idMercado, List<ProdutoDto> produtos) {
		List<Produto> listProdutos = mercadoFeignClient.fazendoCompra(idMercado, produtos).getBody();
		
		listProdutos.forEach(x -> {
			System.out.println("nome: " + x.getNome());
		});
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		return listProdutos;
	}
	
}
