package com.scos.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_servicos")
public class Servico {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
		@OneToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
		private Cliente cliente;
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
		@OneToOne(fetch = FetchType.LAZY, targetEntity = Tecnico.class)
		private Tecnico tecnico;
		@Column(name = "tipo")
		private String tipo;
		@Column(name = "status")
		private String status;
		@Column(name = "prioridade")
		private String prioridade;
		@Column(name = "valor")
		private double valor;
		@Column(name = "descricao")
		private String descricao;
		
		public Servico() {
			super();
		}
		
		public Servico(Cliente cliente, Tecnico tecnico, String tipo, String status, String prioridade, double valor,
				String descricao) {
			super();
			this.cliente = cliente;
			this.tecnico = tecnico;
			this.tipo = tipo;
			this.status = status;
			this.prioridade = prioridade;
			this.valor = valor;
			this.descricao = descricao;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public Tecnico getTecnico() {
			return tecnico;
		}
		public void setTecnico(Tecnico tecnico) {
			this.tecnico = tecnico;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPrioridade() {
			return prioridade;
		}
		public void setPrioridade(String prioridade) {
			this.prioridade = prioridade;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
}
