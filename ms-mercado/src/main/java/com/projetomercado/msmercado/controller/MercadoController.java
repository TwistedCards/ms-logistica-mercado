package com.projetomercado.msmercado.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetomercado.msmercado.dto.ProdutoDto;
import com.projetomercado.msmercado.model.Mercado;
import com.projetomercado.msmercado.model.PedidoFinalizado;
import com.projetomercado.msmercado.model.PedidoRequest;
import com.projetomercado.msmercado.model.Produto;
import com.projetomercado.msmercado.service.MercadoService;
import com.projetomercado.msmercado.service.PedidoFinalizadoService;
import com.projetomercado.msmercado.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
@RequestMapping(value = "/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoFinalizadoService pedidoFinalizadoService;
	
	@GetMapping(value = "/findMercado/{id}")
	public ResponseEntity<Mercado> findById(@PathVariable long id){
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			Mercado objMercado = mercadoService.findById(id);
//			return ResponseEntity.ok(objMercado);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
		
		Mercado objMercado = mercadoService.findById(id);
		return ResponseEntity.ok(objMercado);
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Mercado> registeringMarket(@Valid Mercado mercado){
		try {
			Mercado objMercado = mercadoService.save(mercado);
			return ResponseEntity.ok(objMercado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping(value = "/registerProduto/{idMercado}", consumes = "application/json")
	public ResponseEntity<Mercado> registeringProduct(@RequestBody @Valid List<Produto> produtos, 
														@PathVariable long idMercado){
		try {
			Mercado objMercado = mercadoService.findById(idMercado);
			var mercado = mercadoService.saveProduct(produtos, objMercado);
			return ResponseEntity.ok(mercado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping(value = "/efetuandoCompra/{idMercado}", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<ProdutoDto> fazendoCompra(@PathVariable long idMercado, 
														@RequestBody List<PedidoRequest> pedidosRequest){
		try {
			Mercado objMercado = mercadoService.findById(idMercado);
			ProdutoDto produtoDto = produtoService.processandoPedido(pedidosRequest, objMercado);
			return ResponseEntity.ok(produtoDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	} 
	
	@PostMapping(value = "/finalizandoCompra", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<PedidoFinalizado> finalizandoPedido(@RequestBody ProdutoDto produtoDto){
		try {
			var pedidoFinalizado = pedidoFinalizadoService.setPedidoFinal(produtoDto);
			return ResponseEntity.ok(pedidoFinalizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	} 
	
	
}
