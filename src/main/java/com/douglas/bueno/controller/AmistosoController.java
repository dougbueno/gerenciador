package com.douglas.bueno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Amistoso;
import com.douglas.bueno.repository.AmistosoRepository;

@RestController
@RequestMapping("/api/amistoso")
public class AmistosoController {

	@Autowired
	private AmistosoRepository amistosoRepository;

	@PostMapping
	public Amistoso createCampeonatos(@RequestBody Amistoso amistoso) {
		return amistosoRepository.save(amistoso);
	}

}
