package com.projet.demo.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;
import com.projet.demo.repository.ClasseRepository;
import com.projet.demo.repository.EcoleRepository;

import jakarta.persistence.EntityNotFoundException;
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
	

//	@Override
//	public List<Classe> lire() {
//		// TODO Auto-generated method stub
//		return classeRepository.findAll();
//	}
	
	@Override
	public Page<Classe> lire(int page, int size) {
	    PageRequest pageable = PageRequest.of(page, size);
	    return classeRepository.findAll(pageable);
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





	@Override
	public List<Classe> creerPlusieursClasses(Long id) {
		// TODO Auto-generated method stub
		Ecole ecole = ecoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Ecole non trouvé"));
	    String[] nomsClasses = {"Classe 1", "Classe 2", "Classe 3", "Classe 4", "Classe 5", "Classe 6", "Classe 7", "Classe 8", "Classe 9", "Classe 10",
	    		"Classe 11", "Classe 12", "Classe 13", "Classe 14", "Classe 15", "Classe 16", "Classe 17", "Classe 18", "Classe 19", "Classe 20"};
	    
	    List<Classe> classeM = new ArrayList<>();
	    for(int i = 0; i < 10; i++) {
	        Classe classe = new Classe();
	        classe.setNom(nomsClasses[i]);
	        classe.setEcole(ecole);
	        //classeService.creer(classe, id);
	       classeM.add(classe);	    }
		return classeRepository.saveAll(classeM);
	}





	@Override
	public Page<Classe> lireClasseParEcole(Long id,int page, int size) {
		// TODO Auto-generated method stub
		Ecole ecole = ecoleRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Ecole not found"));

	    //Pageable paging = PageRequest.of(page, size);
	    PageRequest pageRequest = PageRequest.of(page, size);
		return classeRepository.findByEcole(ecole,pageRequest);
	}





	@Override
	public List<Classe> findByNomContainingIgnoreCase(String motCle) {
		// TODO Auto-generated method stub
		
		return classeRepository.findByNomContainingIgnoreCase(motCle);
	}

}
