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
import com.douglas.bueno.model.HistoricoResultados;
import com.douglas.bueno.repository.HistoricoResultadosRepository;

@RestController
@RequestMapping("/api/historico")
public class HistoricoResultadosController {
	@Autowired
	private HistoricoResultadosRepository historicoRepository;
	
	@GetMapping("/{id}")
	public Optional<HistoricoResultados> getById(@PathVariable Long id) {
		return historicoRepository.findById(id);
	}

	@PostMapping("/lista")
	public ResponseEntity<?> createListaResultados(@RequestBody List<HistoricoResultados> resultados) {
		for (HistoricoResultados historicoResultados : resultados) {
			
			historicoRepository.save(historicoResultados);
		}
		return ResponseEntity.ok().build();
	}

	@PostMapping("/resultado")
	public ResponseEntity<?> createHistoricoResultados(@RequestBody HistoricoResultados historicoResultados) {

		historicoRepository.save(historicoResultados);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<HistoricoResultados> updateHistoricoResultados(@PathVariable Long id,
			@RequestBody HistoricoResultados historicoResultados) {
		Optional<HistoricoResultados> optionalHistoricoResultados = historicoRepository.findById(id);

		if (!optionalHistoricoResultados.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		HistoricoResultados existingHistorico = optionalHistoricoResultados.get();
		existingHistorico.setId(id);
		existingHistorico.setUsuario(historicoResultados.getUsuario());
		existingHistorico.setEquipe(historicoResultados.getEquipe());
		existingHistorico.setCampeonato(historicoResultados.getCampeonato());
		existingHistorico.setPontos(historicoResultados.getPontos());
		existingHistorico.setVitoria(historicoResultados.getVitoria());
		existingHistorico.setDerrotas(historicoResultados.getDerrotas());
		existingHistorico.setEmpate(historicoResultados.getEmpate());
		existingHistorico.setGolsMarcados(historicoResultados.getGolsMarcados());
		existingHistorico.setGolsSofridos(historicoResultados.getGolsSofridos());
		existingHistorico.setSaldoGol(historicoResultados.getSaldoGol());

		HistoricoResultados updatedHistoricoResultados = historicoRepository.save(existingHistorico);
		return ResponseEntity.ok(updatedHistoricoResultados);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteHistoricoResultados(@PathVariable Long id) {
		Optional<HistoricoResultados> optionalHistoricoResultados = historicoRepository.findById(id);

		if (!optionalHistoricoResultados.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		historicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<HistoricoResultados> findAll() {
		return historicoRepository.findAllByOrderByPontosDesc();
	}

	@GetMapping("/maisPontos")
	public List<HistoricoResultados> findOneByMaxPontos() {
		return historicoRepository.findOneByMaxPontos();
	}

	@GetMapping("/menosPontos")
	public List<HistoricoResultados> findOneByMinPontos() {
		return historicoRepository.findOneByMinPontos();
	}

	@GetMapping("/maisVitorias")
	public List<HistoricoResultados> findOneByMaxVitoria() {
		return historicoRepository.findOneByMaxVitoria();
	}

	@GetMapping("/menosVitorias")
	public List<HistoricoResultados> findOneByMinVitoria() {
		return historicoRepository.findOneByMinVitoria();
	}

	@GetMapping("/maisEmpates")
	public List<HistoricoResultados> findOneByMaxEmpate() {
		return historicoRepository.findOneByMaxEmpate();
	}

	@GetMapping("/menosEmpates")
	public List<HistoricoResultados> findOneByMinEmpate() {
		return historicoRepository.findOneByMinEmpate();
	}

	@GetMapping("/maisDerrotas")
	public List<HistoricoResultados> findOneByMaxDerrotas() {
		return historicoRepository.findOneByMaxDerrotas();
	}

	@GetMapping("/menosDerrotas")
	public List<HistoricoResultados> findOneByMinDerrotas() {
		return historicoRepository.findOneByMinDerrotas();
	}

	@GetMapping("/maisGolsMarcados")
	public List<HistoricoResultados> findOneByMaxGolsMarcados() {
		return historicoRepository.findOneByMaxGolsMarcados();
	}

	@GetMapping("/menosGolsMarcados")
	public List<HistoricoResultados> findOneByMinGolsMarcados() {
		return historicoRepository.findOneByMinGolsMarcados();
	}

	@GetMapping("/maisGolsSofridos")
	public List<HistoricoResultados> findOneByMaxGolsSofridos() {
		return historicoRepository.findOneByMaxGolsSofridos();
	}

	@GetMapping("/menosGolsSofridos")
	public List<HistoricoResultados> findOneByMinGolsSofridos() {
		return historicoRepository.findOneByMinGolsSofridos();
	}

	@GetMapping("/maisSaldoGol")
	public List<HistoricoResultados> findOneByMaxSaldoGol() {
		return historicoRepository.findOneByMaxSaldoGol();
	}

	@GetMapping("/menosSaldoGol")
	public List<HistoricoResultados> findOneByMinSaldoGol() {
		return historicoRepository.findOneByMinSaldoGol();
	}
}
