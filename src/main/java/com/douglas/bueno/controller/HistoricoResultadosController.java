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

import com.douglas.bueno.model.HistoricoResultados;
import com.douglas.bueno.repository.HistoricoResultadosRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/historico")
public class HistoricoResultadosController {
	@Autowired
	private HistoricoResultadosRepository historicoRepository;

	@PostMapping("/criar")
	public ResponseEntity<?> createHistoricoResultados(@RequestBody List<HistoricoResultados> resultados) {
		for (HistoricoResultados historicoResultados : resultados) {
			historicoResultados
					.setSaldoGol(historicoResultados.getGolsMarcados() - historicoResultados.getGolsSofridos());
			historicoResultados.setQtdPartidas(historicoResultados.getVitoria() + historicoResultados.getEmpate()
					+ historicoResultados.getDerrotas());

			historicoRepository.save(historicoResultados);
		}
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
		existingHistorico.setUsuario(historicoResultados.getUsuario());
		existingHistorico.setPontos(historicoResultados.getPontos());
		existingHistorico.setQtdPartidas(historicoResultados.getQtdPartidas());
		existingHistorico.setVitoria(historicoResultados.getVitoria());
		existingHistorico.setDerrotas(historicoResultados.getDerrotas());
		existingHistorico.setEmpate(historicoResultados.getEmpate());
		existingHistorico.setGolsMarcados(historicoResultados.getGolsMarcados());
		existingHistorico.setGolsSofridos(historicoResultados.getGolsSofridos());
		existingHistorico.setSaldoGol(historicoResultados.getSaldoGol());
		existingHistorico.setAno(historicoResultados.getAno());

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
