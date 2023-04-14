package com.projet.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;
import com.projet.demo.service.EcoleService;

@RestController
@RequestMapping("/ecole")

public class EcoleController {
//la ligne suivante est une inversion de controle
	//on passe par l'interface pour appeller les methoses de la classe qui l'implemente
	
	private final EcoleService ecoleService ;
	
	public EcoleController(EcoleService ecoleService) {
		this.ecoleService = ecoleService;
	}
	
	@PostMapping("/create-multiple")
	public List<Ecole> createMultiple() {
	    return ecoleService.creerPlusieurs();
	}
	
//	@PostMapping("/ajouter-avec-classes")
//    public Ecole creerAvecClasses(@RequestBody Ecole ecole, @RequestBody List<Classe> classes) {
//       // Ecole nouvelleEcole = ecoleService.creerAvecClasses(ecole, classes);
//        //return new ResponseEntity<>(nouvelleEcole, HttpStatus.CREATED);
//        return ecoleService.creerAvecClasses(ecole, classes);
//    }
	
	@PostMapping("/ajouter-avec-classes")
    public ResponseEntity<Ecole> creerAvecClasses(@RequestBody Ecole ecole, @RequestBody List<Classe> classes) {
        Ecole nouvelleEcole = ecoleService.creerAvecClasses(ecole, classes);
        return new ResponseEntity<>(nouvelleEcole, HttpStatus.CREATED);
    }

	
	
	@PostMapping("/create")
	public Ecole create(@RequestBody Ecole ecole) {
		return ecoleService.creer(ecole);
	}
	
	@GetMapping("/read")
	public List<Ecole> read(){
		return ecoleService.lire();
	}
	
	@PutMapping("/update/{id}")
	public Ecole update(@PathVariable Long id,@RequestBody Ecole ecole) {
		return ecoleService.modifier(id, ecole);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return ecoleService.supprimer(id);
	}
}
