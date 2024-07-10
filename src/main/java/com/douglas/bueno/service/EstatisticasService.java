package com.douglas.bueno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bueno.model.Estatisticas;
import com.douglas.bueno.repository.CampeonatosRepository;
import com.douglas.bueno.repository.EquipesRepository;
import com.douglas.bueno.repository.HistoricoResultadosRepository;
import com.douglas.bueno.repository.UsuariosRepository;

@Service
public class EstatisticasService {

	@Autowired
	UsuariosRepository usuariosRepository;

	@Autowired
	EquipesRepository equipesRepository;

	@Autowired
	CampeonatosRepository campeonatosRepository;

	@Autowired
	HistoricoResultadosRepository historicoRepository;

	public Estatisticas obterEstatisticas() {
		Estatisticas estatisticas = new Estatisticas();
		estatisticas.setTotalCampeonatos(campeonatosRepository.countCampeonatos());
		estatisticas.setTotalEquipes(equipesRepository.countEquipes());
		estatisticas.setTotalUsuarios(usuariosRepository.countUsuarios());
		estatisticas.setUsuarioComMaisGolsMarcados(historicoRepository.findOneUsuarioComMaisGols().get(0));
		estatisticas.setUsuarioComMenosGolsMarcados(historicoRepository.findOneUsuarioComMenosGols().get(0));
		estatisticas.setUsuarioComMaisGolsSofridos(historicoRepository.findOneUsuarioComMaisGolsSofridos().get(0));
		estatisticas.setUsuarioComMenosGolsSofridos(historicoRepository.findOneUsuarioComMenosGolsSofridos().get(0));
		estatisticas.setUsuarioComMaisVitorias(historicoRepository.findOneUsuarioComMaisVitorias().get(0));
		estatisticas.setUsuarioComMenosVitorias(historicoRepository.findOneUsuarioComMenosVitorias().get(0));
		estatisticas.setUsuarioComMaisPontos(historicoRepository.findOneUsuarioComMaisPontos().get(0));
		estatisticas.setUsuarioComMenosPontos(historicoRepository.findOneUsuarioComMenosPontos().get(0));
		estatisticas.setUsuarioComMaisDerrotas(historicoRepository.findOneUsuarioComMaisDerrotas().get(0));
		estatisticas.setUsuarioComMenosDerrotas(historicoRepository.findOneUsuarioComMenosDerrotas().get(0));
		estatisticas.setUsuarioComMaisEmpates(historicoRepository.findOneUsuarioComMaisEmpates().get(0));
		estatisticas.setUsuarioComMenosEmpates(historicoRepository.findOneUsuarioComMenosEmpates().get(0));
		
		return estatisticas;
	}

}
