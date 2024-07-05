package com.douglas.bueno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "titulos")
public class Titulos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "campeonato_id", referencedColumnName = "id")
	private Campeonatos campeonatos;

	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name = "equipe_id", referencedColumnName = "id")
	private Equipes equipe;

	@Column(name = "ano")
	private Integer ano;

}
