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

import com.douglas.bueno.facade.JogosFacade;
import com.douglas.bueno.model.Jogos;

@RestController
@RequestMapping("/api/jogos")
public class JogosController {

	@Autowired
	private JogosFacade jogosFacade;

	@PostMapping("/amistoso")
	public ResponseEntity<Jogos> salvarAmistosos(@RequestBody Jogos amistoso) {
		Jogos savedAmistoso = jogosFacade.salvarAmistoso(amistoso);
		return ResponseEntity.ok(savedAmistoso);
	}

	@GetMapping("/amistoso")
	public ResponseEntity<List<Jogos>> recuperaTodosJogosAmistoso() {
		List<Jogos> jogosAtivos = jogosFacade.recuperaTodosJogosAmistoso();
		return ResponseEntity.ok(jogosAtivos);
	}

	@PutMapping("/amistoso/atualizar")
	public ResponseEntity<?> recuperaTodosJogosAmistosoAtualizar() {
		return jogosFacade.recuperaTodosJogosAmistosoAtualizar();
	}

	@PutMapping("/amistoso/{id}")
	public ResponseEntity<?> atualizarJogoAmistoso(@PathVariable Long id, @RequestBody Jogos jogos) {
		return jogosFacade.atualizarJogoAmistoso(id, jogos);
	}

	@DeleteMapping("/amistoso/{id}")
	public ResponseEntity<?> deleteJogos(@PathVariable Long id) {
		return jogosFacade.deleteJogo(id);
	}

}
