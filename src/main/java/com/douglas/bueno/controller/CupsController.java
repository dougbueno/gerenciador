package com.douglas.bueno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Campeonatos;
import com.douglas.bueno.model.Cup;
import com.douglas.bueno.repository.CampeonatosRepository;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping("/api/cups")
public class CupsController {

	@Autowired
	private CampeonatosRepository campeonatosRepository;

	@PostMapping("/criar")
	public Cup createCampeonatos(@RequestBody Cup cup) {
		return cup;
	}
	
	@PostMapping("/sortear")
	public Campeonatos sortearCampeonatos(@RequestBody Campeonatos campeonatos) {
		return campeonatosRepository.save(campeonatos);
	}

}
