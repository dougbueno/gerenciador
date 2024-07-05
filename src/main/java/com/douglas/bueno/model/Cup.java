package com.douglas.bueno.model;

import java.util.List;

import lombok.Data;

@Data
public class Cup {

	private String nomedoCampeonato;
	private List<Participantes> listaParticipantes;
	private List<Jogos> listaJogos;

}
