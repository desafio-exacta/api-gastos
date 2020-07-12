package com.exacta.desafio.desafioexacta.domain.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Gasto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Gasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty(value = "id", access = Access.WRITE_ONLY)
	@JsonIgnore
	private long id;
	
	@Column(name = "descricao")
	@JsonProperty(value = "descricao")
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	@JsonProperty(value = "data")	
	@JsonIgnore
	private Calendar data;
	
	@Column(name = "valor")
	@JsonProperty(value = "valor")
	private double valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tag_id")	
	@JsonManagedReference(value = "tag-gasto")
	@JsonIgnore
	private Tag tag;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id")
	@JsonManagedReference(value = "pessoa-gasto")
	@JsonIgnore
	private Pessoa pessoa;

	public long getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	public Calendar getData() {
		return data;
	}
	
	@JsonIgnore
	public void setData(Calendar data) {
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
