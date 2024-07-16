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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public ResponseEntity<?> insereResultados(@RequestBody List<HistoricoResultados> historicoResultados) {
		Integer ordem = historicoRepository
				.findMaxOrdemHistoricoByCampeonato(historicoResultados.get(0).getCampeonato());
		ordem = ordem == null ? 1 : ordem + 1;

		for (HistoricoResultados historico : historicoResultados) {
			historico.setOrdem(Long.valueOf(ordem));
			historicoRepository.save(historico);
		}

		return ResponseEntity.ok().build();
	}

	@PostMapping("/premierLeague")
	public ResponseEntity<?> insereResultadosPremierLeague(@RequestBody List<HistoricoResultados> historicoResultados) {

		List<HistoricoResultados> historicoGeral = historicoRepository
				.findAllByCampeonatoAndAnoCampeonato("Premier League", historicoResultados.get(0).getAnoCampeonato());

		Integer ordem = historicoRepository
				.findMaxOrdemHistoricoByCampeonato(historicoResultados.get(0).getCampeonato());
		if (historicoGeral.isEmpty() && ordem == null ) {
			for (HistoricoResultados historico : historicoResultados) {
				historicoRepository.save(historico);
			}
		} else if(historicoGeral.isEmpty() && ordem != null ){
			ordem+=1;
			for (HistoricoResultados historico : historicoResultados) {
				historico.setOrdem(Long.valueOf(ordem));
				historicoRepository.save(historico);
			}
		}
		else {for (HistoricoResultados historicoAntigo : historicoGeral) {
				for (HistoricoResultados historicoAtual : historicoResultados) {
					if (historicoAtual.getUsuario().equals(historicoAntigo.getUsuario())) {
						historicoAntigo.setDerrotas(historicoAntigo.getDerrotas() + historicoAtual.getDerrotas());
						historicoAntigo.setEmpates(historicoAntigo.getEmpates() + historicoAtual.getEmpates());
						historicoAntigo
								.setGolsMarcados(historicoAntigo.getGolsMarcados() + historicoAtual.getGolsMarcados());
						historicoAntigo
								.setGolsSofridos(historicoAntigo.getGolsSofridos() + historicoAtual.getGolsSofridos());
						historicoAntigo.setPontos(historicoAntigo.getPontos() + historicoAtual.getPontos());
						historicoAntigo.setSaldoGol(historicoAntigo.getSaldoGol() + historicoAtual.getSaldoGol());
						historicoAntigo.setVitorias(historicoAntigo.getVitorias() + historicoAtual.getVitorias());
						historicoAntigo.setEquipe(historicoAtual.getEquipe());
						historicoRepository.save(historicoAntigo);
					}
				}
			}
		}

		return ResponseEntity.ok().build();
	}

}
