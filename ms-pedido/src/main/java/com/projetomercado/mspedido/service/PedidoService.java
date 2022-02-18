package com.projetomercado.mspedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomercado.mspedido.dto.ProdutoDto;
import com.projetomercado.mspedido.feignclients.MercadoFeignClient;
import com.projetomercado.mspedido.model.Mercado;
import com.projetomercado.mspedido.model.PedidoRequest;

@Service
public class PedidoService {

	@Autowired
	private MercadoFeignClient mercadoFeignClient;
	
	public Mercado getMercado(long mercadoId) {
		Mercado mercado = mercadoFeignClient.findByCnpj(mercadoId).getBody();
		return mercado;
	}
	
	public ProdutoDto fazendoPedido(long idMercado, List<PedidoRequest> pedidosRequest) {
		ProdutoDto produtoDto = mercadoFeignClient.fazendoCompra(idMercado, pedidosRequest).getBody();
		
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		return produtoDto;
	}
	
}
