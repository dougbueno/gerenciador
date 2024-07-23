package com.douglas.bueno.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.model.Equipes;

public interface EquipesFacade {

	List<Equipes> getAllEquipes();

	Optional<Equipes> getById(Long id);

	Equipes createEquipes(Equipes equipes);

	ResponseEntity<Equipes> updateEquipes(Long id, Equipes equipes);

	ResponseEntity<?> deleteEquipes(Long id);

}
