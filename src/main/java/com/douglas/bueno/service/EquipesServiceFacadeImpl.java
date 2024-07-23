package com.douglas.bueno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglas.bueno.facade.EquipesFacade;
import com.douglas.bueno.model.Equipes;
import com.douglas.bueno.repository.EquipesRepository;

@Service
public class EquipesServiceFacadeImpl implements EquipesFacade{

    @Autowired
    private EquipesRepository equipesRepository;

    @Override
	public List<Equipes> getAllEquipes() {
        return equipesRepository.findAllByOrderByNomeEquipeAsc();
    }

    @Override
	public Optional<Equipes> getById(Long id) {
        return equipesRepository.findById(id);
    }

    @Override
	public Equipes createEquipes(Equipes equipes) {
        return equipesRepository.save(equipes);
    }

    @Override
	public ResponseEntity<Equipes> updateEquipes(Long id, Equipes equipes) {
        Optional<Equipes> optionalEquipes = equipesRepository.findById(id);

        if (!optionalEquipes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Equipes existingEquipes = optionalEquipes.get();
        existingEquipes.setNomeEquipe(equipes.getNomeEquipe());

        Equipes updatedEquipes = equipesRepository.save(existingEquipes);
        return ResponseEntity.ok(updatedEquipes);
    }

    @Override
	public ResponseEntity<?> deleteEquipes(Long id) {
        Optional<Equipes> optionalEquipes = equipesRepository.findById(id);

        if (!optionalEquipes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        equipesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
