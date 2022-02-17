package com.projetomercado.msmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomercado.msmercado.model.Mercado;
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
	
	public Mercado save(Mercado mercado) {
		return mercadoRepository.save(mercado);
	}
	
}
