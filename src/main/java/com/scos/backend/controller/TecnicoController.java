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
import com.scos.backend.model.Tecnico;
import com.scos.backend.repository.TecnicoRepository;

@RestController
@RequestMapping("/api/v1/")
public class TecnicoController {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	// getTecnicos
	@GetMapping("tecnicos")
	public List<Tecnico> getAllTecnicos() {
		return this.tecnicoRepository.findAll();
	}
	// getTecnicoById
	@GetMapping("/tecnicos/{id}")
	public ResponseEntity<Tecnico> getTecnicoById(@PathVariable(value = "id") Long tecnicoId)
			throws ResourceNotFoundException {
		Tecnico tecnico = tecnicoRepository.findById(tecnicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Tecnico com o id : " + tecnicoId));
		return ResponseEntity.ok().body(tecnico);
	}
	// Criar Tecnico
	@PostMapping("tecnicos")
	public Tecnico createTecnico(@RequestBody Tecnico tecnico ) {
		return this.tecnicoRepository.save(tecnico);
	}
	
	// Atualizar Tecnico
	@PutMapping("tecnicos/{id}")
	public ResponseEntity<Tecnico> updateTecnico(@PathVariable(value = "id") Long tecnicoId,
			@Validated @RequestBody Tecnico tecnicoUpdate) throws ResourceNotFoundException {
		Tecnico tecnico = tecnicoRepository.findById(tecnicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Tecnico com o id : " + tecnicoId));
		tecnico.setEmail(tecnicoUpdate.getEmail());
		tecnico.setNome(tecnicoUpdate.getNome());
		tecnico.setNumAtendimentos(tecnicoUpdate.getNumAtendimentos());
		tecnico.setTelefone(tecnicoUpdate.getTelefone());
			
		return ResponseEntity.ok(this.tecnicoRepository.save(tecnico));
		
	}
	
	// Deletar Tecnico
	@DeleteMapping("tecnicos/{id}")
	public Map<String, Boolean> deleteTecnico(@PathVariable(value = "id") Long tecnicoId) throws ResourceNotFoundException {
		Tecnico tecnico = tecnicoRepository.findById(tecnicoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um Tecnico com o id : " + tecnicoId));
		this.tecnicoRepository.delete(tecnico);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
