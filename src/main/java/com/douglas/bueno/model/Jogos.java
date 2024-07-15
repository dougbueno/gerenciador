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
@Table(name = "jogos")
public class Jogos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "casa")
	private String casa;
	@Column(name = "golsCasa")
	private String golsCasa;
	@Column(name = "visitante")
	private String visitante;
	@Column(name = "golsVisitante")
	private String golsVisitante;
	@Column(name = "dataAmistoso")
	private LocalDateTime dataAmistoso = LocalDateTime.now();
	@Column(name = "campeoanto")
	private String campeonato;
	@Column(name = "ativo")
	private Boolean ativo=Boolean.TRUE;

}
