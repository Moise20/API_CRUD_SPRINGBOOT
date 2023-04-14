package com.projet.demo.service;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;
import com.projet.demo.repository.EcoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EcoleServiceImplement implements EcoleService{
	private final EcoleRepository ecoleRepository ;
	
	public EcoleServiceImplement(EcoleRepository ecoleRepository) {
		this.ecoleRepository = ecoleRepository;
	}

	@Override
	public Ecole creer(Ecole ecole) {
		// TODO Auto-generated method stub
		
		return ecoleRepository.save(ecole);
	}

	@Override
	public List<Ecole> lire() {
		// TODO Auto-generated method stub
		return ecoleRepository.findAll();
	}

	@Override
	public Ecole modifier(Long id, Ecole ecole) {
		// TODO Auto-generated method stub
		return ecoleRepository.findById(id)
				.map(e->{
					
					e.setNom(ecole.getNom());
					e.setDescription(ecole.getDescription());
					return ecoleRepository.save(e);
				}).orElseThrow(()->new RuntimeException("Ecole non trouvé"))
				;
	}

	@Override
	public String supprimer(Long id) {
		// TODO Auto-generated method stub
		ecoleRepository.deleteById(id);
		return "Ecole supprimé";
	}

	@Override
	public List<Ecole> creerPlusieurs() {
		// TODO Auto-generated method stub
		List<String> noms = Arrays.asList("Ecole 1", "Ecole 2", "Ecole 3", "Ecole 4", "Ecole 5", "Ecole 6", "Ecole 7", "Ecole 8", "Ecole 9", "Ecole 10");
		List<String> descriptions = Arrays.asList("Description 1", "Description 2", "Description 3", "Description 4", "Description 5", "Description 6", "Description 7", "Description 8", "Description 9", "Description 10");

		List<Ecole> ecoles1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
		    Ecole ecole = new Ecole();
		    ecole.setNom(noms.get((int) (Math.random() * noms.size())));
		    ecole.setDescription(descriptions.get((int) (Math.random() * descriptions.size())));
//		    String nom = LocalDateTime.now().toString() + "_" + Math.random();
//		    String description = LocalDateTime.now().toString() + "_" + Math.random();
//		    ecole.setNom(nom);
//		    ecole.setDescription(description);
		    
		    ecoles1.add(ecole);
		}

		return ecoleRepository.saveAll(ecoles1);
	}

	@Override
	public Ecole creerAvecClasses(Ecole ecole, List<Classe> classes) {
		// TODO Auto-generated method stub
		ecole.setClasse(classes);
	    return ecoleRepository.save(ecole);
	}

}
