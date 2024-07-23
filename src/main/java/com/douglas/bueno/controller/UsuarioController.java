package com.douglas.bueno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.facade.UsuarioFacade;
import com.douglas.bueno.model.Usuarios;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioFacade usuarioFacade;

	@GetMapping
	public List<Usuarios> getAllUsuarios() {
		return usuarioFacade.getAllUsuarios();
	}

	@GetMapping("/{id}")
	public Optional<Usuarios> getPorId(@PathVariable Long id) {
		return usuarioFacade.getPorId(id);
	}

	@PostMapping("/criar")
	public Usuarios createUsuarios(@RequestBody Usuarios usuarios) {
		return usuarioFacade.createUsuarios(usuarios);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios) {

		return usuarioFacade.updateUsuarios(id, usuarios);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuarios(@PathVariable Long id) {
		return usuarioFacade.deleteUsuarios(id);
	}
}
