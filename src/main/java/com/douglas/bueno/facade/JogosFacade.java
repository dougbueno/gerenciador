package com.douglas.bueno.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.model.Jogos;

public interface JogosFacade {

	Jogos salvarAmistoso(Jogos amistoso);

	List<Jogos> recuperaTodosJogosAmistoso();

	ResponseEntity<?> recuperaTodosJogosAmistosoAtualizar();

	ResponseEntity<Jogos> atualizarJogoAmistoso(Long id, Jogos jogos);

	ResponseEntity<?> deleteJogo(Long id);

	

}
