package com.douglas.bueno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
