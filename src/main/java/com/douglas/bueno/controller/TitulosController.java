package com.douglas.bueno.controller;

import java.util.List;

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

import com.douglas.bueno.dto.UsuarioTitulosDTO;
import com.douglas.bueno.facade.TitulosFacade;
import com.douglas.bueno.model.Titulos;

@RestController
@RequestMapping("/api/titulos")
public class TitulosController {

	@Autowired
	private TitulosFacade titulosFacade;

	@GetMapping
	public List<Titulos> getAllTitulos() {
		return titulosFacade.getAllTitulos();
	}

	@GetMapping("/listaCampeoes")
	public List<UsuarioTitulosDTO> findOrderByMaxTitulos() {
		return titulosFacade.findOrderByMaxTitulos();
	}

	@PostMapping
	public Titulos createTitulos(@RequestBody Titulos titulos) {
		return titulosFacade.createTitulos(titulos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Titulos> updateTitulos(@PathVariable Long id, @RequestBody Titulos titulos) {
		return titulosFacade.updateTitulos(id, titulos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTitulos(@PathVariable Long id) {
		return titulosFacade.deleteTitulos(id);
	}
}
