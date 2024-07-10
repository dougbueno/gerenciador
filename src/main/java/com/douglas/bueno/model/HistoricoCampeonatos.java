package com.douglas.bueno.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HistoricoCampeonatos {

	private String campeonato;
	private List<HistoricoResultados> historico;

}
