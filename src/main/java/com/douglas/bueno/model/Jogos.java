package com.douglas.bueno.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
