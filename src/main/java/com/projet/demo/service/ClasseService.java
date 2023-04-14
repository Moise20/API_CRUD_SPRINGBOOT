package com.projet.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;

public interface ClasseService {
	
	List<Classe> creerPlusieurs(Long id);
	
	Classe creer(Classe classe,Long id);
	
	//List<Classe> lire();
	Page<Classe> lire(int page, int size);

	Page<Classe> lireClasseParEcole(Long id,int page, int size);
	
	List<Classe> findByNomContainingIgnoreCase(String motCle);
	
	Classe modifier(Long id,Classe classe);
	
	String supprimer(Long id);

}
