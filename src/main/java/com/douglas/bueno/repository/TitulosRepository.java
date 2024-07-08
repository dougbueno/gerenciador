package com.douglas.bueno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglas.bueno.model.Titulos;

public interface TitulosRepository extends JpaRepository<Titulos, Long> {

	@Query("SELECT t.usuario, COUNT(*) as quantidadeTitulos FROM Titulos t GROUP BY t.usuario ORDER BY quantidadeTitulos DESC")
	List<Object[]> findOrderByMaxTitulos();

	@Query("SELECT t FROM Titulos t ORDER BY t.ano DESC, t.id DESC")
	List<Titulos> findAllOrderedByAnoDescAndIdDesc();
}
