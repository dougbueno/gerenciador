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

import com.douglas.bueno.model.Campeonatos;
import com.douglas.bueno.repository.CampeonatosRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatosController {

	@Autowired
	private CampeonatosRepository campeonatosRepository;

	@GetMapping
	public List<Campeonatos> getAllCampeonatos() {
		return campeonatosRepository.findAllByOrderByNomeCampeonatoAsc();
	}

	@PostMapping("/criar")
	public Campeonatos createCampeonatos(@RequestBody Campeonatos campeonatos) {
		return campeonatosRepository.save(campeonatos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Campeonatos> updateCampeonatos(@PathVariable Long id, @RequestBody Campeonatos campeonatos) {
		Optional<Campeonatos> optionalCampeonatos = campeonatosRepository.findById(id);

		if (!optionalCampeonatos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Campeonatos existingCampeoantos = optionalCampeonatos.get();
		existingCampeoantos.setNomeCampeonato(campeonatos.getNomeCampeonato());

		Campeonatos updatedCampeonatos = campeonatosRepository.save(existingCampeoantos);
		return ResponseEntity.ok(updatedCampeonatos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCampeonatos(@PathVariable Long id) {
		Optional<Campeonatos> optionalCampeonatos = campeonatosRepository.findById(id);

		if (!optionalCampeonatos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		campeonatosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
