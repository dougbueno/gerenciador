package com.douglas.bueno.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Campeonatos;
import com.douglas.bueno.model.HistoricoCampeonatos;
import com.douglas.bueno.model.HistoricoResultados;
import com.douglas.bueno.repository.CampeonatosRepository;
import com.douglas.bueno.repository.HistoricoResultadosRepository;

@RestController
@RequestMapping("/api/historico")
public class HistoricoResultadosController {
	@Autowired
	private HistoricoResultadosRepository historicoRepository;

	@Autowired
	private CampeonatosRepository campeonatosRepository;

	@GetMapping("/ordenado")
	public List<HistoricoCampeonatos> getResultadosOrdenados() {
		List<Campeonatos> listaCampeonatos = campeonatosRepository.findAllByOrderByNomeCampeonatoAsc();

		List<HistoricoResultados> listaHistorico = historicoRepository.findAllOrderByCampeonatoAndPontos();

		List<HistoricoCampeonatos> filtrohist = new ArrayList<>();
		for (Campeonatos camp : listaCampeonatos) {
			HistoricoCampeonatos historico = new HistoricoCampeonatos();
			historico.setCampeonato(camp.getNomeCampeonato());
			historico.setHistorico(listaHistorico.stream()
					.filter(resultado -> camp.getNomeCampeonato().equals(resultado.getCampeonato()))
					.collect(Collectors.toList()));
			filtrohist.add(historico);
		}

		return filtrohist;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCampeonatos(@PathVariable Long id) {
		Optional<HistoricoResultados> optional = historicoRepository.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		historicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
