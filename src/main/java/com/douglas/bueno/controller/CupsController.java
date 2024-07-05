package com.douglas.bueno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Cup;
import com.douglas.bueno.service.CupService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cups")
public class CupsController {

	@Autowired
	private CupService cupService;

	@PostMapping("/criar")
	public Cup createCampeonatos(@RequestBody Cup cup) {
		return cupService.sortear(cup);
	}

}
