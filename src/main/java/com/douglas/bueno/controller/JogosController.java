package com.douglas.bueno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Jogos;
import com.douglas.bueno.repository.AmistosoRepository;

@RestController
@RequestMapping("/api/jogos")
public class JogosController {

	@Autowired
	private AmistosoRepository amistosoRepository;

	@PostMapping("/amistoso")
	public Jogos salvarAmistosos(@RequestBody Jogos amistoso) {
		return amistosoRepository.save(amistoso);
	}
	
	@GetMapping("/amistoso")
	public List<Jogos> recuperaTodosJogosAmistoso() {
		return amistosoRepository.findAll();
	}

}
