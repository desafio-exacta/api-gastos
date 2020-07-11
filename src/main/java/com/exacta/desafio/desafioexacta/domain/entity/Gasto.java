package com.exacta.desafio.desafioexacta.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Gasto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Gasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty(value = "id")
	private long id;
	
	@Column(name = "descricao")
	@JsonProperty(value = "descricao")
	private String descricao;
	
	@Column(name = "data")
	@JsonProperty(value = "data")
	private String data;
	
	@Column(name = "valor")
	@JsonProperty(value = "valor")
	private double valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tag_id")
	@JsonIgnore
	@JsonManagedReference(value = "tag-gasto")
	private Tag tag;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id")
	@JsonIgnore
	@JsonManagedReference(value = "pessoa-gasto")
	private Pessoa pessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
