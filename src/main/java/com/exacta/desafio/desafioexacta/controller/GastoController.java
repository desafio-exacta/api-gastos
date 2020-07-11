package com.exacta.desafio.desafioexacta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exacta.desafio.desafioexacta.domain.entity.Gasto;
import com.exacta.desafio.desafioexacta.service.GastoService;

@RestController
@RequestMapping(path = "/api/v1/gasto")
public class GastoController {

	@Autowired
	private GastoService service;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Gasto add(@RequestBody Gasto gasto) {
		return service.add(gasto);
	}
	
	@GetMapping(path = "/", produces = "application/json")
	public Iterable<Gasto> findAll() {
		return service.findAll();
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public Gasto findById(@PathVariable("id") long id) {
		return service.findById(id);
	}
}
