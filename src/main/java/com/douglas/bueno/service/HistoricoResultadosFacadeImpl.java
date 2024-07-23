package com.douglas.bueno.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglas.bueno.facade.HistoricoResultadosFacade;
import com.douglas.bueno.model.Campeonatos;
import com.douglas.bueno.model.HistoricoCampeonatos;
import com.douglas.bueno.model.HistoricoResultados;
import com.douglas.bueno.repository.CampeonatosRepository;
import com.douglas.bueno.repository.HistoricoResultadosRepository;

@Service
public class HistoricoResultadosFacadeImpl implements HistoricoResultadosFacade {

	@Autowired
	private HistoricoResultadosRepository historicoRepository;

	@Autowired
	private CampeonatosRepository campeonatosRepository;

	@Override
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

	@Override
	public ResponseEntity<?> deleteHistoricoResultados(Long id) {
		Optional<HistoricoResultados> optional = historicoRepository.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		historicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	@Transactional
	public ResponseEntity<?> insereResultados(List<HistoricoResultados> historicoResultados) {
		Integer ordem = historicoRepository
				.findMaxOrdemHistoricoByCampeonato(historicoResultados.get(0).getCampeonato());
		ordem = ordem == null ? 1 : ordem + 1;

		for (HistoricoResultados historico : historicoResultados) {
			historico.setOrdem(Long.valueOf(ordem));
			historicoRepository.save(historico);
		}

		return ResponseEntity.ok().build();
	}

	@Override
	@Transactional
	public ResponseEntity<?> insereResultadosPremierLeague(List<HistoricoResultados> historicoResultados) {
		List<HistoricoResultados> historicoGeral = historicoRepository
				.findAllByCampeonatoAndAnoCampeonato("Premier League", historicoResultados.get(0).getAnoCampeonato());

		Integer ordem = historicoRepository
				.findMaxOrdemHistoricoByCampeonato(historicoResultados.get(0).getCampeonato());
		if (historicoGeral.isEmpty() && ordem == null) {
			for (HistoricoResultados historico : historicoResultados) {
				historicoRepository.save(historico);
			}
		} else if (historicoGeral.isEmpty() && ordem != null) {
			ordem += 1;
			for (HistoricoResultados historico : historicoResultados) {
				historico.setOrdem(Long.valueOf(ordem));
				historicoRepository.save(historico);
			}
		} else {
			for (HistoricoResultados historicoAntigo : historicoGeral) {
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
