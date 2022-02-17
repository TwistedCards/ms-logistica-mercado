package com.projetomercado.msmercado.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomercado.msmercado.model.Mercado;
import com.projetomercado.msmercado.model.Produto;
import com.projetomercado.msmercado.repository.MercadoRepository;

@Service
public class MercadoService {

	@Autowired
	private MercadoRepository mercadoRepository;
	
	public Mercado findById(long id) {
		return mercadoRepository.findById(id).get();
	}
	
	public List<Mercado> findAll() {
		return mercadoRepository.findAll();
	}
	
	@Transactional
	public Mercado save(Mercado mercado) {
		return mercadoRepository.save(mercado);
	}
	
	public Mercado salvandoProduto(List<Produto> produtos, Mercado mercado) {
		List<Produto> listProduto = new ArrayList<>();
		
		produtos.forEach(produtoMandado -> {
			var p = new Produto();
			p = produtoMandado;
			p.setMercado(mercado);
			listProduto.add(p);
		});
		
		mercado.getProdutos().addAll(listProduto);
		return this.save(mercado);
	}
	
	
}
