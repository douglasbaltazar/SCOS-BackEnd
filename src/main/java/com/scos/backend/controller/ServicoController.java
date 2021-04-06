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
import com.scos.backend.model.Servico;
import com.scos.backend.model.Tecnico;
import com.scos.backend.repository.ServicoRepository;
import com.scos.backend.repository.TecnicoRepository;

@RestController
@RequestMapping("/api/v1/")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;

	// getServicos
	@GetMapping("servicos")
	public List<Servico> getAllServico() {
		return this.servicoRepository.findAll();
	}
	// getServicoById
	@GetMapping("/servicos/{id}")
	public ResponseEntity<Servico> getServicoById(@PathVariable(value = "id") Long servicoId)
			throws ResourceNotFoundException {
		Servico servico = servicoRepository.findById(servicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Servico com o id : " + servicoId));
		return ResponseEntity.ok().body(servico);
	}
	// Criar Servico
	@PostMapping("servicos")
	public Servico createServico(@RequestBody Servico servico) {
		return this.servicoRepository.save(servico);
	}
	
	// Atualizar Servico
	@PutMapping("servicos/{id}")
	public ResponseEntity<Servico> updateServico(@PathVariable(value = "id") Long servicoId,
			@Validated @RequestBody Servico servicoUpdate) throws ResourceNotFoundException {
		Servico servico = servicoRepository.findById(servicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Serviço com o id : " + servicoId));
		servico.setCliente(servicoUpdate.getCliente());
		servico.setDescricao(servicoUpdate.getDescricao());
		servico.setPrioridade(servicoUpdate.getPrioridade());
		servico.setStatus(servicoUpdate.getStatus());
		servico.setTecnico(servicoUpdate.getTecnico());
		servico.setTipo(servicoUpdate.getTipo());
		servico.setValor(servicoUpdate.getValor());
		servico.setId(servicoUpdate.getId());
		return ResponseEntity.ok(this.servicoRepository.save(servico));
		
	}
	
	// Deletar Servico
	@DeleteMapping("servicos/{id}")
	public Map<String, Boolean> deleteServico(@PathVariable(value = "id") Long servicoId) throws ResourceNotFoundException {
		Servico servico = servicoRepository.findById(servicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Serviço com o id : " + servicoId));
		this.servicoRepository.delete(servico);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
