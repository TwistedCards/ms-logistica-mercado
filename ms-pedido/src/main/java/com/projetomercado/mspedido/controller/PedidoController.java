package com.projetomercado.mspedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomercado.mspedido.dto.ProdutoDto;
import com.projetomercado.mspedido.model.Mercado;
import com.projetomercado.mspedido.model.PedidoRequest;
import com.projetomercado.mspedido.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/{idMercado}/buscandoMercado")
	public Mercado getPayment(@PathVariable long idMercado){
		return pedidoService.getMercado(idMercado);
	}
	
	@PostMapping(value = "/{idMercado}/criandoPedido")
	public ResponseEntity<ProdutoDto> getCompra(@PathVariable long idMercado, 
												@RequestBody List<PedidoRequest> pedidosRequest){
		ProdutoDto produtoDto = pedidoService.fazendoPedido(idMercado, pedidosRequest);
		return ResponseEntity.ok(produtoDto);
	}
	
}
