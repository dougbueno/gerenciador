package com.douglas.bueno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "titulos")
public class Titulos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "campeonato")
	private String campeonato;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "equipe")
	private String equipe;

	@Column(name = "ano")
	private Integer ano;

}
