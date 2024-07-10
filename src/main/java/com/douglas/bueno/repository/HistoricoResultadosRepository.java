package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.HistoricoResultados;

public interface HistoricoResultadosRepository extends JpaRepository<HistoricoResultados, Long> {
	List<HistoricoResultados> findAllByOrderByPontosDesc();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.pontos = (SELECT MAX(hr2.pontos) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxPontos();

	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.pontos = (SELECT MIN(hr2.pontos) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinPontos();

	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.vitoria = (SELECT MAX(hr2.vitoria) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxVitoria();

	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.vitoria = (SELECT MIN(hr2.vitoria) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinVitoria();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.empate = (SELECT MAX(hr2.empate) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxEmpate();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.empate = (SELECT MIN(hr2.empate) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinEmpate();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.derrotas = (SELECT MAX(hr2.derrotas) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxDerrotas();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.derrotas = (SELECT MIN(hr2.derrotas) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinDerrotas();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.golsMarcados = (SELECT MAX(hr2.golsMarcados) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxGolsMarcados();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.golsMarcados = (SELECT MIN(hr2.golsMarcados) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinGolsMarcados();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.golsSofridos = (SELECT MAX(hr2.golsSofridos) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxGolsSofridos();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.golsSofridos = (SELECT MIN(hr2.golsSofridos) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinGolsSofridos();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.saldoGol = (SELECT MAX(hr2.saldoGol) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMaxSaldoGol();
	
	@Query("SELECT hr FROM HistoricoResultados hr WHERE hr.saldoGol = (SELECT MIN(hr2.saldoGol) FROM HistoricoResultados hr2)")
	List<HistoricoResultados> findOneByMinSaldoGol();
}
