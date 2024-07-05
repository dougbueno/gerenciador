package com.douglas.bueno.model;

import java.util.List;

import lombok.Data;

@Data
public class Cup {

	private Campeonatos nomedoCampeonato;
	private List<Equipes> equipes;

}
