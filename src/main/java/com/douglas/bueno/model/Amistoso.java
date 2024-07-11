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
@Table(name = "amistoso")
public class Amistoso {
	
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

}
