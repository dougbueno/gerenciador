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

import com.douglas.bueno.facade.EquipesFacade;
import com.douglas.bueno.model.Equipes;

@RestController
@RequestMapping("/api/equipes")
public class EquipesController {

	@Autowired
	private EquipesFacade equipesFacade;

	@GetMapping
	public List<Equipes> getAllEquipes() {
		return equipesFacade.getAllEquipes();
	}

	@GetMapping("/{id}")
	public Optional<Equipes> getById(@PathVariable Long id) {
		return equipesFacade.getById(id);
	}

	@PostMapping
	public Equipes createEquipes(@RequestBody Equipes equipes) {
		return equipesFacade.createEquipes(equipes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipes> updateEquipes(@PathVariable Long id, @RequestBody Equipes equipes) {
		return equipesFacade.updateEquipes(id, equipes);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEquipes(@PathVariable Long id) {
		return equipesFacade.deleteEquipes(id);
	}
}
