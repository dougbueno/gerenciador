package com.douglas.bueno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.facade.HistoricoResultadosFacade;
import com.douglas.bueno.model.HistoricoCampeonatos;
import com.douglas.bueno.model.HistoricoResultados;

@RestController
@RequestMapping("/api/historico")
public class HistoricoResultadosController {

	@Autowired
	private HistoricoResultadosFacade historicoResultadosFacade;

	@GetMapping("/ordenado")
	public List<HistoricoCampeonatos> getResultadosOrdenados() {
		return historicoResultadosFacade.getResultadosOrdenados();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCampeonatos(@PathVariable Long id) {
		return historicoResultadosFacade.deleteHistoricoResultados(id);
	}

	@PostMapping("/campeonato")
	public ResponseEntity<?> insereResultados(@RequestBody List<HistoricoResultados> historicoResultados) {
		return historicoResultadosFacade.insereResultados(historicoResultados);
	}

	@PostMapping("/premierLeague")
	public ResponseEntity<?> insereResultadosPremierLeague(@RequestBody List<HistoricoResultados> historicoResultados) {
		return historicoResultadosFacade.insereResultadosPremierLeague(historicoResultados);
	}

}