package com.projetomercado.msmercado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomercado.msmercado.model.Mercado;
import com.projetomercado.msmercado.model.Produto;
import com.projetomercado.msmercado.service.MercadoService;

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
	public ResponseEntity<Mercado> registeringProduct(@Valid Produto produto, @PathVariable long idMercado){
		try {
			Mercado objMercado = mercadoService.findById(idMercado);
			Produto p = new Produto();
			
			p = produto;
			p.setMercado(objMercado);
			
			objMercado.getProdutos().add(p);
			
			mercadoService.save(objMercado);
			
			return ResponseEntity.ok(objMercado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
