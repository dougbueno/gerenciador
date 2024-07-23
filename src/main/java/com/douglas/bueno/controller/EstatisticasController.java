package com.douglas.bueno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.facade.EstatisticasFacade;
import com.douglas.bueno.model.Estatisticas;

@RestController
@RequestMapping("/api")
public class EstatisticasController {

	@Autowired
	private EstatisticasFacade estatisticasFacade;

	@GetMapping("/estatisticas")
	public Estatisticas obterEstatisticas() {
		return estatisticasFacade.obterEstatisticas();
	}

}
