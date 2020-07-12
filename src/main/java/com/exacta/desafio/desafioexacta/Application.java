package com.exacta.desafio.desafioexacta;

import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exacta.desafio.desafioexacta.domain.dao.GastoRepository;
import com.exacta.desafio.desafioexacta.domain.dao.PessoaRepository;
import com.exacta.desafio.desafioexacta.domain.dao.TagRepository;
import com.exacta.desafio.desafioexacta.domain.entity.Gasto;
import com.exacta.desafio.desafioexacta.domain.entity.Pessoa;
import com.exacta.desafio.desafioexacta.domain.entity.Tag;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	protected CommandLineRunner init(
			final GastoRepository gastoRepository
			, final PessoaRepository pessoaRepository
			, final TagRepository tagRepository) {

		return args -> {
			Tag t1 = new Tag("ALIMENTACAO");
			Tag t2 = new Tag("TRANSPORTE");
			Tag t3 = new Tag("SAÚDE");
			tagRepository.save(t1);
			tagRepository.save(t2);
			tagRepository.save(t3);
			
			Pessoa p1 = new Pessoa("Joao II");
			pessoaRepository.save(p1);
			
			// Produto inicio
			Gasto g1 = new Gasto();
			Gasto g2 = new Gasto();
			
			g1.setData(Calendar.getInstance());
			g1.setDescricao("Lanche");
			g1.setValor(10.20);
			g1.setPessoa(p1);
			g1.setTag(t1);			
			gastoRepository.save(g1);
			
			g2.setData(Calendar.getInstance());
			g2.setDescricao("Ônibus");
			g2.setValor(4.70);
			g2.setPessoa(p1);
			g2.setTag(t2);	
			gastoRepository.save(g2);			
		};
	}
}
