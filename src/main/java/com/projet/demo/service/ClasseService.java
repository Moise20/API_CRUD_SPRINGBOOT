package com.projet.demo.service;

import java.util.List;

import com.projet.demo.modele.Classe;

public interface ClasseService {
	
	Classe creer(Classe classe,Long id);
	
	List<Classe> lire();
	
	Classe modifier(Long id,Classe classe);
	
	String supprimer(Long id);

}
