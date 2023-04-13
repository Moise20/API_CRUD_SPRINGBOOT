package com.projet.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
