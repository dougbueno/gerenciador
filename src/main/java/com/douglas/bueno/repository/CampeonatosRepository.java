package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.Campeonatos;

public interface CampeonatosRepository extends JpaRepository<Campeonatos, Long> {
	List<Campeonatos> findAllByOrderByNomeCampeonatoAsc();
	
	@Query("SELECT COUNT(u) FROM Campeonatos u")
	long countCampeonatos();
}
