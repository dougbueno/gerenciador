package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.bueno.model.Equipes;

public interface EquipesRepository extends JpaRepository<Equipes, Long> {
	  List<Equipes> findAllByOrderByNomeEquipeAsc();
}
