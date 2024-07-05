package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.bueno.model.HistoricoResultados;

public interface HistoricoResultadosRepository extends JpaRepository<HistoricoResultados, Long> {

	List<HistoricoResultados> findAllByOrderByPontosDesc();
}
