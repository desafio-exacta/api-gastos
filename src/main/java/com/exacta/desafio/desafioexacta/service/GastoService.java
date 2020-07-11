package com.exacta.desafio.desafioexacta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exacta.desafio.desafioexacta.domain.dao.GastoRepository;
import com.exacta.desafio.desafioexacta.domain.dao.PessoaRepository;
import com.exacta.desafio.desafioexacta.domain.dao.TagRepository;
import com.exacta.desafio.desafioexacta.domain.entity.Gasto;
import com.exacta.desafio.desafioexacta.domain.entity.Pessoa;
import com.exacta.desafio.desafioexacta.domain.entity.Tag;

@Service
public class GastoService {
	@Autowired
	private GastoRepository gastoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private TagRepository tagRepository;
	
	public Gasto add(Gasto gasto) {		
		Pessoa p = pessoaRepository.findByNome(gasto.getPessoa().getNome());
		Tag t = tagRepository.findByNome(gasto.getTag().getNome());
		if(p == null) p = addPessoa(gasto.getPessoa().getNome());
		if(t == null) t = addTag(gasto.getTag().getNome());
		gasto.setPessoa(p);
		gasto.setTag(t);
		return gastoRepository.save(gasto);
	}
	
	public Pessoa addPessoa(String nome) {
		return pessoaRepository.save(new Pessoa(nome));
	}
	
	public Tag addTag(String nome) {
		return tagRepository.save(new Tag(nome.toUpperCase()));
	}
	
	public Gasto findById(long id) {
		return gastoRepository.findById(id);
	}
	
	public Iterable<Gasto> findAll(){
		return gastoRepository.findAll();
	}
}
