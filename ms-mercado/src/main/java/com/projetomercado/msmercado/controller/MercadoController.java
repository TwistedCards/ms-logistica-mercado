package com.projetomercado.msmercado.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.projetomercado.msmercado.model.Produto;
import com.projetomercado.msmercado.service.MercadoService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
@RequestMapping(value = "/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;
	
	@GetMapping(value = "/findMercado/{id}")
	public ResponseEntity<Mercado> findByCnpj(@PathVariable long id){
		try {
			Mercado objMercado = mercadoService.findById(id);
			return ResponseEntity.ok(objMercado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
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
	
	@PostMapping(value = "/registerProduto/{idMercado}")
	public ResponseEntity<Mercado> registeringProduct(@RequestBody @Valid List<Produto> produtos, @PathVariable long idMercado){
		try {
			Mercado objMercado = mercadoService.findById(idMercado);
			List<Produto> listProduto = new ArrayList<>();
			
			produtos.forEach(produtoMandado -> {
				var p = new Produto();
				p = produtoMandado;
				p.setMercado(objMercado);
				listProduto.add(p);
			});
			
			objMercado.getProdutos().addAll(listProduto);
			mercadoService.save(objMercado);
			return ResponseEntity.ok(objMercado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	private BigDecimal valorTotalCompra;
	
	@PostMapping(value = "/efetuandoCompra/{idMercado}",  consumes = "application/json")
	@ResponseBody
	public ResponseEntity<List<Produto>> fazendoCompra(@PathVariable long idMercado, @RequestBody List<ProdutoDto> produtos){
		valorTotalCompra = BigDecimal.ZERO;
		
		try {
			Mercado objMercado = mercadoService.findById(idMercado);
			List<Produto> produtosComprados = new ArrayList<>();
			
			produtos.forEach(produtoEscolhido -> {
				objMercado.getProdutos().forEach(produtoMercado -> {
					if(produtoEscolhido.getCodigo().equals(produtoMercado.getCodigo())) {
//						valorTotalCompra = valorTotalCompra.add(produtoMercado.getPreco().multiply(produtoEscolhido.getQtde()));
						produtosComprados.add(produtoMercado);
					}
				});
			});
			
			return ResponseEntity.ok(produtosComprados);
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	} 
	
	
	
	
}
