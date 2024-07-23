package com.douglas.bueno.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.douglas.bueno.model.Usuarios;

public interface UsuarioFacade {

	List<Usuarios> getAllUsuarios();

	Optional<Usuarios> getPorId(Long id);

	Usuarios createUsuarios(Usuarios usuarios);

	ResponseEntity<Usuarios> updateUsuarios(Long id, Usuarios usuarios);

	ResponseEntity<?> deleteUsuarios(Long id);

}
