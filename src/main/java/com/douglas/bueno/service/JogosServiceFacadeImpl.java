package com.douglas.bueno.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglas.bueno.facade.JogosFacade;
import com.douglas.bueno.model.Jogos;
import com.douglas.bueno.repository.AmistosoRepository;

@Service
public class JogosServiceFacadeImpl implements JogosFacade {

	@Autowired
	private AmistosoRepository amistosoRepository;

	@Autowired
	private AmistosoService amistosoService;

	@Override
	@Transactional
	public Jogos salvarAmistoso(Jogos amistoso) {
		return amistosoRepository.save(amistoso);
	}

	@Override
	public List<Jogos> recuperaTodosJogosAmistoso() {
		return amistosoRepository.findAllByAtivoOrderByDataAmistosoAsc(true);
	}

	@Override
	public ResponseEntity<?> recuperaTodosJogosAmistosoAtualizar() {
		List<Jogos> jogosAtivos = amistosoRepository.findAllByAtivoOrderByDataAmistosoAsc(true);

		amistosoService.atualizarAtivos(jogosAtivos);

		return ResponseEntity.ok().build();
	}

	@Override
	@Transactional
	public ResponseEntity<Jogos> atualizarJogoAmistoso(Long id, Jogos jogos) {
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

	@Override
	@Transactional
	public ResponseEntity<?> deleteJogo(Long id) {
		Optional<Jogos> optionalJogos = amistosoRepository.findById(id);

		if (!optionalJogos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		amistosoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
