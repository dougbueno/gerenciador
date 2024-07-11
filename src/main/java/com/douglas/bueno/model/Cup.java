package com.douglas.bueno.model;

import java.util.List;

import lombok.Data;

@Data
public class Cup {

	private String campeonato;
	private List<String> usuarios;
	private List<Jogos> listaJogos;

}
