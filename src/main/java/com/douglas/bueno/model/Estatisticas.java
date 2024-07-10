package com.douglas.bueno.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Estatisticas {

	private Long totalCampeonatos;
	private Long totalEquipes;
	private Long totalUsuarios;
	private String usuarioComMaisGolsMarcados;
	private String usuarioComMenosGolsMarcados;
	private String usuarioComMaisGolsSofridos;
	private String usuarioComMenosGolsSofridos;
	private String usuarioComMaisVitorias;
	private String usuarioComMenosVitorias;
	private String usuarioComMaisPontos;
	private String usuarioComMenosPontos;
	private String usuarioComMaisDerrotas;
	private String usuarioComMenosDerrotas;
	private String usuarioComMaisEmpates;
	private String usuarioComMenosEmpates;

}
