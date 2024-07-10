package com.douglas.bueno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "historico_resultados")
public class HistoricoResultados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ordemHistorico")
	private Long ordem;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "equipe")
	private String equipe;
	@Column(name = "campeonato")
	private String campeonato;
	@Column(name = "pontos")
	private Integer pontos;
	@Column(name = "vitorias")
	private Integer vitoria;
	@Column(name = "empate")
	private Integer empate;
	@Column(name = "derrotas")
	private Integer derrotas;
	@Column(name = "golsMarcados")
	private Integer golsMarcados;
	@Column(name = "golsSofridos")
	private Integer golsSofridos;
	@Column(name = "saldoGol")
	private Integer saldoGol;


}
