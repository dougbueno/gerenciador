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

import com.douglas.bueno.model.Jogos;
import com.douglas.bueno.repository.AmistosoRepository;
import com.douglas.bueno.service.AmistosoService;

@RestController
@RequestMapping("/api/jogos")
public class JogosController {

	@Autowired
	private AmistosoRepository amistosoRepository;

	@Autowired
	private AmistosoService amistosoService;

	@PostMapping("/amistoso")
	public ResponseEntity<Jogos> salvarAmistosos(@RequestBody Jogos amistoso) {

		amistosoRepository.save(amistoso);
		return ResponseEntity.ok(amistoso);
	}

	@GetMapping("/amistoso")
	public ResponseEntity<List<Jogos>> recuperaTodosJogosAmistoso() {
		List<Jogos> jogosAtivos = amistosoRepository.findAllByAtivoOrderByDataAmistosoAsc(true);

		return ResponseEntity.ok(jogosAtivos);
	}

	@PutMapping("/amistoso/atualizar")
	public ResponseEntity<?> recuperaTodosJogosAmistosoAtualizar() {
		List<Jogos> jogosAtivos = amistosoRepository.findAllByAtivoOrderByDataAmistosoAsc(true);

		amistosoService.atualizarAtivos(jogosAtivos);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/amistoso/{id}")
	public ResponseEntity<?> atualizarJogoAmistoso(@PathVariable Long id,@RequestBody Jogos jogos) {
		Optional<Jogos> optionalJogos = amistosoRepository.findById(id);

		if (!optionalJogos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Jogos existingJogos = optionalJogos.get();
		existingJogos.setGolsCasa(jogos.getGolsCasa());
		existingJogos.setGolsVisitante(jogos.getGolsVisitante());
		amistosoRepository.save(existingJogos);
		return ResponseEntity.ok(existingJogos);
	}

	@DeleteMapping("/amistoso/{id}")
	public ResponseEntity<?> deleteJogos(@PathVariable Long id) {
		Optional<Jogos> optionalJogos = amistosoRepository.findById(id);

		if (!optionalJogos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		amistosoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
