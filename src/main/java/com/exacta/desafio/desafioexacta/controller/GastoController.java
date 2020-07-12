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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Gasto")
@RestController
@RequestMapping("/")
public class GastoController {

	@Autowired
	private GastoService service;
	
	@ApiOperation(value = "Incluir gasto")
	@PostMapping(path = "api/gastos", consumes = "application/json", produces = "application/json")
	public Gasto add(@RequestBody Gasto gasto) {
		return service.add(gasto);
	}
	
	@ApiOperation(value = "Listar todos os gastos")
	@GetMapping(path = "api/gastos", produces = "application/json")
	public Iterable<Gasto> findAll() {
		return service.findAll();
	}
	
	@ApiOperation(value = "Listar gasto por id")
	@GetMapping(path = "api/gastos/{id}", produces = "application/json")
	public Gasto findById(@PathVariable("id") long id) {
		return service.findById(id);
	}
}
