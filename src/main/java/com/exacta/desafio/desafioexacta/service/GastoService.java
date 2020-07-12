package com.exacta.desafio.desafioexacta.service;

import java.util.Calendar;

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
		return gastoRepository.save(manterRelacionamento(gasto));
	}
	
	public Gasto update(long id, Gasto gasto) {		
		if(gastoRepository.existsById(id)) {
			gasto = manterRelacionamento(gasto);
			gasto.setId(id);
			return gastoRepository.save(gasto);
		}
		return null;
	}
	
	public void delete(long id) {
		gastoRepository.deleteById(id);
	}
	
	public Gasto findById(long id) {
		return gastoRepository.findById(id);
	}
	
	public Iterable<Gasto> findAll(){
		return gastoRepository.findAll();
	}
	
	private Pessoa addPessoa(String nome) {
		return pessoaRepository.save(new Pessoa(nome));
	}
	
	private Tag addTag(String nome) {
		return tagRepository.save(new Tag(nome.toUpperCase()));
	}
	
	private Gasto manterRelacionamento(Gasto gasto) {
		String pessoa = gasto.getPessoa().getNome();
		String tag = gasto.getTag().getNome();
		
		Pessoa p = pessoaRepository.findByNome(pessoa);
		Tag t = tagRepository.findByNome(tag.toUpperCase());
		
		if(p == null) p = addPessoa(pessoa);
		if(t == null) t = addTag(tag);
		
		gasto.setPessoa(p);
		gasto.setTag(t);
		gasto.setData(Calendar.getInstance());
		
		return gasto;
	}
}
