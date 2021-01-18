package com.scos.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scos.backend.exception.ResourceNotFoundException;
import com.scos.backend.model.Cliente;
import com.scos.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	// getClientes
	@GetMapping("clientes")
	public List<Cliente> getAllClientes() {
		return this.clienteRepository.findAll();
	}
	// getClienteById
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
			throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Cliente com o id : " + clienteId));
		return ResponseEntity.ok().body(cliente);
	}
	// Criar Cliente
	@PostMapping("clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	// Atualizar Cliente
	@PutMapping("clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
			@Validated @RequestBody Cliente clienteUpdate) throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Cliente com o id : " + clienteId));
		cliente.setEmail(clienteUpdate.getEmail());
		cliente.setNome(clienteUpdate.getNome());
		cliente.setTelefone(cliente.getTelefone());
			
		return ResponseEntity.ok(this.clienteRepository.save(cliente));
		
	}
	
	// Deletar Cliente
	@DeleteMapping("clientes/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long clienteId) throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Cliente com o id : " + clienteId));
		this.clienteRepository.delete(cliente);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
