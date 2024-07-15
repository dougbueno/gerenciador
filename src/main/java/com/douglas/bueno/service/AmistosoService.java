package com.douglas.bueno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bueno.model.Jogos;
import com.douglas.bueno.repository.AmistosoRepository;

@Service
public class AmistosoService {

	@Autowired
	AmistosoRepository amistosoRepository;

	public void atualizarAtivos(List<Jogos> jogosAtivos) {
		for (Jogos jogo : jogosAtivos) {
			jogo.setAtivo(false);
			amistosoRepository.save(jogo);
		}
	}

}
