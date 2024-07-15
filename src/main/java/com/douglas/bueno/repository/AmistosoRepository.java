package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.bueno.model.Jogos;

public interface AmistosoRepository extends JpaRepository<Jogos, Long> {

	List<Jogos> findAllByAtivoOrderByDataAmistosoAsc(Boolean ativo);

}
