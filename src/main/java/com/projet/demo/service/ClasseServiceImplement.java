package com.projet.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;
import com.projet.demo.repository.ClasseRepository;
import com.projet.demo.repository.EcoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasseServiceImplement implements ClasseService{
	
	private final ClasseRepository classeRepository;
	private final EcoleRepository ecoleRepository;
	public ClasseServiceImplement(ClasseRepository classeRepository ,EcoleRepository ecoleRepository) {
		this.classeRepository=classeRepository;
		this.ecoleRepository=ecoleRepository;
	}
	
	
	
	

	@Override
	public  Classe creer(Classe classe,Long id) {
		// TODO Auto-generated method stub
					Ecole ecole =	ecoleRepository.findById(id).orElseThrow();
					System.out.println(ecole);
			classe.setEcole(ecole);
		return classeRepository.save(classe);
	}
	

	@Override
	public List<Classe> lire() {
		// TODO Auto-generated method stub
		return classeRepository.findAll();
	}

	@Override
	public Classe modifier(Long id, Classe classe) {
		// TODO Auto-generated method stub
		return classeRepository.findById(id)
				.map(s->
				{
					s.setNom(classe.getNom());
					s.setEcole(classe.getEcole());
					return classeRepository.save(s);
				}).orElseThrow(()->new RuntimeException("classe non trouvé"));
				
	}

	@Override
	public String supprimer(Long id) {
		// TODO Auto-generated method stub
		classeRepository.deleteById(id);
		return "classe supprimé";
	}

}
