package com.douglas.bueno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Equipes;
import com.douglas.bueno.repository.EquipesRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/equipes")
public class EquipesController {
	@Autowired
	private EquipesRepository equipesRepository;

	@GetMapping("/")
	public List<Equipes> getAllEquipes() {
		return equipesRepository.findAllByOrderByNomeEquipeAsc();
	}

	@PostMapping("/criar")
	public Equipes createEquipes(@RequestBody Equipes equipes) {
		return equipesRepository.save(equipes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipes> updateUsuarios(@PathVariable Long id, @RequestBody Equipes equipes) {
		Optional<Equipes> optionalEquipes = equipesRepository.findById(id);

		if (!optionalEquipes.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Equipes existingEquipes = optionalEquipes.get();
		existingEquipes.setNomeEquipe(equipes.getNomeEquipe());

		Equipes updatedEquipes = equipesRepository.save(existingEquipes);
		return ResponseEntity.ok(updatedEquipes);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuarios(@PathVariable Long id) {
		Optional<Equipes> optionalEquipes = equipesRepository.findById(id);

		if (!optionalEquipes.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		equipesRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
