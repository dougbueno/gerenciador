package com.douglas.bueno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.douglas.bueno.dto.UsuarioTitulosDTO;
import com.douglas.bueno.facade.TitulosFacade;
import com.douglas.bueno.model.Titulos;
import com.douglas.bueno.model.Usuarios;
import com.douglas.bueno.repository.TitulosRepository;


@Service
public class TitulosServiceFacadeImpl implements TitulosFacade {

	@Autowired
	private TitulosRepository titulosRepository;

	@Override
	public List<Titulos> getAllTitulos() {
		return titulosRepository.findAllOrderedByAnoDescAndIdDesc();
	}
	
	@Override
	public Optional<Titulos> getPorId(@PathVariable Long id) {
		return titulosRepository.findById(id);
	}

	@Override
	public List<UsuarioTitulosDTO> findOrderByMaxTitulos() {
		List<Object[]> resultados = titulosRepository.findOrderByMaxTitulos();
		return resultados.stream().map(row -> new UsuarioTitulosDTO((String) row[0], (Long) row[1]))
				.collect(Collectors.toList());
	}

	@Override
	public Titulos createTitulos(@RequestBody Titulos titulos) {
		return titulosRepository.save(titulos);
	}

	@Override
	public ResponseEntity<Titulos> updateTitulos(@PathVariable Long id, @RequestBody Titulos titulos) {
		Optional<Titulos> optionalTitulos = titulosRepository.findById(id);

		if (!optionalTitulos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Titulos existingTitulos = optionalTitulos.get();
		existingTitulos.setAno(titulos.getAno());
		existingTitulos.setCampeonato(titulos.getCampeonato());
		existingTitulos.setUsuario(titulos.getUsuario());
		existingTitulos.setEquipe(titulos.getEquipe());

		Titulos updatedsetQtdTitulos = titulosRepository.save(existingTitulos);
		return ResponseEntity.ok(updatedsetQtdTitulos);
	}

	@Override
	public ResponseEntity<?> deleteTitulos(@PathVariable Long id) {
		Optional<Titulos> optionalTitulos = titulosRepository.findById(id);

		if (!optionalTitulos.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		titulosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
