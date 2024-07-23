package com.douglas.bueno.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.douglas.bueno.facade.UsuarioFacade;
import com.douglas.bueno.model.Usuarios;
import com.douglas.bueno.repository.UsuariosRepository;

@Service
public class UsuarioServiceFacadeImpl implements UsuarioFacade {

	@Autowired
	UsuariosRepository usuariosRepository;

	@Override
	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAllByOrderByNomeAsc();
	}

	@Override
	public Optional<Usuarios> getPorId(@PathVariable Long id) {
		return usuariosRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuarios createUsuarios(@RequestBody Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@Override
	@Transactional
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios) {
		Optional<Usuarios> optionalUsuarios = usuariosRepository.findById(id);

		if (!optionalUsuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Usuarios existingUsuarios = optionalUsuarios.get();
		existingUsuarios.setNome(usuarios.getNome());
		existingUsuarios.setEquipe(usuarios.getEquipe() == null ? existingUsuarios.getEquipe() : usuarios.getEquipe());

		Usuarios updatedusuario = usuariosRepository.save(existingUsuarios);
		return ResponseEntity.ok(updatedusuario);
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteUsuarios(@PathVariable Long id) {
		Optional<Usuarios> optionalUsuarios = usuariosRepository.findById(id);

		if (!optionalUsuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuariosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
