package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.Equipes;

public interface EquipesRepository extends JpaRepository<Equipes, Long> {
	  List<Equipes> findAllByOrderByNomeEquipeAsc();
	  
	  @Query("SELECT COUNT(u) FROM Equipes u")
		long countEquipes();
}
