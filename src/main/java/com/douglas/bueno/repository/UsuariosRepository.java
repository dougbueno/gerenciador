package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findAllByOrderByNomeAsc();
	
	@Query("SELECT COUNT(u) FROM Usuarios u")
	long countUsuarios();

}
