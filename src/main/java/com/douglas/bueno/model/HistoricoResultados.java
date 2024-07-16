package com.douglas.bueno.model;

import java.time.LocalDateTime;

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
	private Long ordem = 1L;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "equipe")
	private String equipe;
	@Column(name = "campeonato")
	private String campeonato;
	@Column(name = "pontos")
	private Integer pontos;
	@Column(name = "vitorias")
	private Integer vitorias;
	@Column(name = "empates")
	private Integer empates;
	@Column(name = "derrotas")
	private Integer derrotas;
	@Column(name = "golsMarcados")
	private Integer golsMarcados;
	@Column(name = "golsSofridos")
	private Integer golsSofridos;
	@Column(name = "saldoGol")
	private Integer saldoGol;
	@Column(name = "anoCampeonato")
	private Integer anoCampeonato = LocalDateTime.now().getYear();


}
