package com.douglas.bueno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.facade.CampeonatosFacade;
import com.douglas.bueno.model.Campeonatos;

@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatosController {

	@Autowired
	private CampeonatosFacade campeonatosFacade;

	@GetMapping
	public List<Campeonatos> getAllCampeonatos() {
		return campeonatosFacade.getAllCampeonatos();
	}

	@GetMapping("/{id}")
	public Optional<Campeonatos> getById(@PathVariable Long id) {
		return campeonatosFacade.getById(id);
	}

	@PostMapping
	public Campeonatos createCampeonatos(@RequestBody Campeonatos campeonatos) {
		return campeonatosFacade.createCampeonatos(campeonatos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCampeonatos(@PathVariable Long id, @RequestBody Campeonatos campeonatos) {
		return campeonatosFacade.updateCampeonatos(id, campeonatos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCampeonatos(@PathVariable Long id) {
		return campeonatosFacade.deleteCampeonatos(id);
	}
}
