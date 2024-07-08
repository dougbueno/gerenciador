package com.douglas.bueno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bueno.model.Usuarios;
import com.douglas.bueno.repository.UsuariosRepository;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuariosRepository usuariosRepository;

	@GetMapping
	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAllByOrderByNomeAsc();
	}

	@GetMapping("/{id}")
	public Optional<Usuarios> getPorId(@PathVariable Long id) {
		return usuariosRepository.findById(id);
	}

	@PostMapping("/criar")
	public Usuarios createUsuarios(@RequestBody Usuarios usuarios) {

		return usuariosRepository.save(usuarios);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios) {
		Optional<Usuarios> optionalUsuarios = usuariosRepository.findById(id);

		if (!optionalUsuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Usuarios existingUsuarios = optionalUsuarios.get();
		existingUsuarios.setNome(usuarios.getNome());
		existingUsuarios.setEquipe(usuarios.getEquipe());

		Usuarios updatedusuario = usuariosRepository.save(existingUsuarios);
		return ResponseEntity.ok(updatedusuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuarios(@PathVariable Long id) {
		Optional<Usuarios> optionalUsuarios = usuariosRepository.findById(id);

		if (!optionalUsuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuariosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
