package com.douglas.bueno.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.dto.UsuarioTitulosDTO;
import com.douglas.bueno.model.Titulos;

public interface TitulosFacade {

	List<Titulos> getAllTitulos();

	List<UsuarioTitulosDTO> findOrderByMaxTitulos();

	Titulos createTitulos(Titulos titulos);

	ResponseEntity<Titulos> updateTitulos(Long id, Titulos titulos);

	ResponseEntity<?> deleteTitulos(Long id);

	Optional<Titulos> getPorId(Long id);

}
