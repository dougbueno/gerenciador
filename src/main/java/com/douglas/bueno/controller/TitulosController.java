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

import com.douglas.bueno.model.Titulos;
import com.douglas.bueno.repository.TitulosRepository;

@RestController
@RequestMapping("/api/titulos")
public class TitulosController {

	@Autowired
	private TitulosRepository titulosRepository;

	@GetMapping
	public List<Titulos> getAllTitulos() {
		return titulosRepository.findAll();
	}

	@PostMapping("/criar")
	public Titulos createTitulos(@RequestBody Titulos titulos) {
		return titulosRepository.save(titulos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Titulos> updateTitulos(@PathVariable Long id, @RequestBody Titulos titulos) {
		Optional<Titulos> optionalTitulos = titulosRepository.findById(id);

		if (!optionalTitulos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Titulos existingTitulos = optionalTitulos.get();
		existingTitulos.setAno(titulos.getAno());
		existingTitulos.setCampeonatos(titulos.getCampeonatos());
		existingTitulos.setUsuario(titulos.getUsuario());
		existingTitulos.setEquipe(titulos.getEquipe());

		Titulos updatedsetQtdTitulos = titulosRepository.save(existingTitulos);
		return ResponseEntity.ok(updatedsetQtdTitulos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTitulos(@PathVariable Long id) {
		Optional<Titulos> optionalTitulos = titulosRepository.findById(id);

		if (!optionalTitulos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		titulosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
