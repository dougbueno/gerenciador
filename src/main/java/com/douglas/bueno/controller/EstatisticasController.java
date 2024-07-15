package com.douglas.bueno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Estatisticas;
import com.douglas.bueno.service.EstatisticasService;

@RestController
@RequestMapping("/api")
public class EstatisticasController {

	@Autowired
	private EstatisticasService estatisticasService;

	@GetMapping("/estatisticas")
	public ResponseEntity<Estatisticas> obterEstatisticas() {

		return ResponseEntity.ok(estatisticasService.obterEstatisticas());
	}

}
