package com.exacta.desafio.desafioexacta.domain.dao;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.exacta.desafio.desafioexacta.domain.entity.Pessoa;

@RestResource(exported = false)
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findByNome(@PathParam("nome") String nome);
}