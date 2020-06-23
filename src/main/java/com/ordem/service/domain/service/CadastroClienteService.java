package com.ordem.service.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordem.service.domain.exception.NegocioException;
import com.ordem.service.domain.model.Cliente;
import com.ordem.service.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		
		Cliente clienteExist = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExist != null && !clienteExist.equals(cliente)) {
			throw new NegocioException("já existe um cliente cadastrado com este E-Mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
