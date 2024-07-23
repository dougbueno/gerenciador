package com.douglas.bueno.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.model.HistoricoCampeonatos;
import com.douglas.bueno.model.HistoricoResultados;

public interface HistoricoResultadosFacade {

    List<HistoricoCampeonatos> getResultadosOrdenados();

    ResponseEntity<?> deleteHistoricoResultados(Long id);

    ResponseEntity<?> insereResultados(List<HistoricoResultados> historicoResultados);

    ResponseEntity<?> insereResultadosPremierLeague(List<HistoricoResultados> historicoResultados);
   
}
