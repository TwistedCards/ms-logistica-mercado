package com.projetomercado.mspedido.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetomercado.mspedido.dto.ProdutoDto;
import com.projetomercado.mspedido.model.Mercado;
import com.projetomercado.mspedido.model.PedidoRequest;

@Component
@FeignClient(name = "ms-mercado", path = "/mercados")
public interface MercadoFeignClient {

	@GetMapping(value = "/findMercado/{id}")
	public ResponseEntity<Mercado> findByCnpj(@PathVariable long id);
	
	@PostMapping(value = "/efetuandoCompra/{idMercado}", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<ProdutoDto> fazendoCompra(@PathVariable long idMercado, 
														@RequestBody List<PedidoRequest> pedidoRequest);
	
}
