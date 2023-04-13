package com.projet.demo.service;

import java.util.List;

import com.projet.demo.modele.Ecole;

public interface EcoleService {

	Ecole creer (Ecole ecole);
	
	List<Ecole> lire();
	
	Ecole modifier(Long id, Ecole ecole);
	
	String supprimer(Long id);
}
