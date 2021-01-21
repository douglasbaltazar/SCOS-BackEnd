package com.scos.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_servicos")
public class Servico {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name = "clienteid")
		private long clienteid;
		@Column(name = "tecnicoid")
		private long tecnicoid;
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
		
		public Servico(long clienteid, long tecnicoid, String tipo, String status, String prioridade, double valor,
				String descricao) {
			super();
			this.clienteid = clienteid;
			this.tecnicoid = tecnicoid;
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
		public long getClienteid() {
			return clienteid;
		}
		public void setClienteid(long clienteid) {
			this.clienteid = clienteid;
		}
		public long getTecnicoid() {
			return tecnicoid;
		}
		public void setTecnicoid(long tecnicoid) {
			this.tecnicoid = tecnicoid;
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
