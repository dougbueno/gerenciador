package com.douglas.bueno.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglas.bueno.facade.CampeonatosFacade;
import com.douglas.bueno.model.Campeonatos;
import com.douglas.bueno.repository.CampeonatosRepository;

@Service
public class CampeonatosServiceFacadeImpl implements CampeonatosFacade {

	@Autowired
	private CampeonatosRepository campeonatosRepository;

	@Override
	public List<Campeonatos> getAllCampeonatos() {
		return campeonatosRepository.findAllByOrderByNomeCampeonatoAsc();
	}

	@Override
	public Optional<Campeonatos> getById(Long id) {
		return campeonatosRepository.findById(id);
	}

	@Override
	@Transactional
	public Campeonatos createCampeonatos(Campeonatos campeonatos) {
		return campeonatosRepository.save(campeonatos);
	}

	@Override
	@Transactional
	public ResponseEntity<Campeonatos> updateCampeonatos(Long id, Campeonatos campeonatos) {
		Optional<Campeonatos> optionalCampeonatos = campeonatosRepository.findById(id);

		if (!optionalCampeonatos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Campeonatos existingCampeonatos = optionalCampeonatos.get();
		existingCampeonatos.setNomeCampeonato(campeonatos.getNomeCampeonato());

		Campeonatos updatedCampeonatos = campeonatosRepository.save(existingCampeonatos);
		return ResponseEntity.ok(updatedCampeonatos);
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteCampeonatos(Long id) {
		Optional<Campeonatos> optionalCampeonatos = campeonatosRepository.findById(id);

		if (!optionalCampeonatos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		campeonatosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
