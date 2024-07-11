package com.douglas.bueno.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.douglas.bueno.model.Cup;
import com.douglas.bueno.model.Jogos;

@Service
public class CupService {

	public Cup sortear(Cup cup) {

		List<String> listaEquipes = new ArrayList<>();
		listaEquipes.addAll(cup.getUsuarios());

		List<List<String>> jogosIdaVolta = sortearJogosIdaVolta(listaEquipes);
		List<Jogos> listaJogos = new ArrayList<>();

		for (List<String> jogo : jogosIdaVolta) {

			Jogos jogos = new Jogos();
			jogos.setNomeEquipeCasa(jogo.get(0));
			jogos.setNomeEquipeFora(jogo.get(1));
			listaJogos.add(jogos);
			Jogos jogos2 = new Jogos();
			jogos2.setNomeEquipeCasa(jogo.get(1));
			jogos2.setNomeEquipeFora(jogo.get(0));
			listaJogos.add(jogos2);

		}
		Collections.shuffle(listaJogos);
		cup.setListaJogos(listaJogos);
		return cup;
	}

	public static List<List<String>> sortearJogosIdaVolta(List<String> times) {
		List<List<String>> jogosIdaVolta = new ArrayList<>();

		// Gera todas as combinações de jogos possíveis
		for (int i = 0; i < times.size(); i++) {
			for (int j = i + 1; j < times.size(); j++) {
				List<String> jogoIda = new ArrayList<>();
				jogoIda.add(times.get(i));
				jogoIda.add(times.get(j));
				jogosIdaVolta.add(jogoIda);
			}
		}

		// Embaralha a ordem dos jogos para simular um sorteio aleatório

		return jogosIdaVolta;
	}

}
