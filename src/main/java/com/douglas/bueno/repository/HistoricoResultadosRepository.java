package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.HistoricoResultados;

public interface HistoricoResultadosRepository extends JpaRepository<HistoricoResultados, Long> {

	List<HistoricoResultados> findAllByCampeonatoAndAnoCampeonato(String campeonato, Integer ano);

	@Query("SELECT h FROM HistoricoResultados h ORDER BY h.campeonato,h.ordem, h.pontos DESC")
	List<HistoricoResultados> findAllOrderByCampeonatoAndPontos();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario "
			+ "ORDER BY SUM(h.golsMarcados) DESC")
	List<String> findOneUsuarioComMaisGols();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h GROUP BY h.usuario " + "ORDER BY SUM(h.golsMarcados) ASC")
	List<String> findOneUsuarioComMenosGols();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario "
			+ "ORDER BY SUM(h.golsSofridos) DESC")
	List<String> findOneUsuarioComMaisGolsSofridos();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h GROUP BY h.usuario " + "ORDER BY SUM(h.golsSofridos) ASC")
	List<String> findOneUsuarioComMenosGolsSofridos();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario "
			+ "ORDER BY SUM(h.vitorias) DESC")
	List<String> findOneUsuarioComMaisVitorias();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.vitorias) ASC")
	List<String> findOneUsuarioComMenosVitorias();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.pontos) ASC")
	List<String> findOneUsuarioComMenosPontos();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.pontos) DESC")
	List<String> findOneUsuarioComMaisPontos();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario "
			+ "ORDER BY SUM(h.derrotas) DESC")
	List<String> findOneUsuarioComMaisDerrotas();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.derrotas) ASC")
	List<String> findOneUsuarioComMenosDerrotas();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.empates) DESC")
	List<String> findOneUsuarioComMaisEmpates();

	@Query("SELECT h.usuario " + "FROM HistoricoResultados h " + "GROUP BY h.usuario " + "ORDER BY SUM(h.empates) ASC")
	List<String> findOneUsuarioComMenosEmpates();

	@Query("SELECT MAX(hr.ordem) FROM HistoricoResultados hr WHERE hr.campeonato = :campeonato")
	Integer findMaxOrdemHistoricoByCampeonato(String campeonato);

}
