package com.douglas.bueno.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.model.Campeonatos;

public interface CampeonatosFacade {

	List<Campeonatos> getAllCampeonatos();

	Optional<Campeonatos> getById(Long id);

	Campeonatos createCampeonatos(Campeonatos campeonatos);

	ResponseEntity<Campeonatos> updateCampeonatos(Long id, Campeonatos campeonatos);

	ResponseEntity<?> deleteCampeonatos(Long id);

}
