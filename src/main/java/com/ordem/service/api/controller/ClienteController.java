package com.ordem.service.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordem.service.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Paulo");
		cliente1.setEmail("paulo@gmail.com");
		cliente1.setTelefone("9 8888-8888");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Vinicius");
		cliente2.setEmail("vinicius@gmail.com");
		cliente2.setTelefone("9 8888-8888");		
		
		return Arrays.asList(cliente1, cliente2);
	}
}
