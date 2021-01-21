package com.scos.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tecnicos")
public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "numatendimentos")
	private int numatendimentos;
	
	public Tecnico() {
		super();
	}
	
	public Tecnico(String nome, String email, String telefone, int numAtendimentos) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.numatendimentos = numAtendimentos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getNumAtendimentos() {
		return numatendimentos;
	}
	public void setNumAtendimentos(int numAtendimentos) {
		this.numatendimentos = numAtendimentos;
	}
}
