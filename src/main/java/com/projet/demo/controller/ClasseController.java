package com.projet.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.modele.Classe;
import com.projet.demo.service.ClasseService;

@RestController
@RequestMapping("/classe")
public class ClasseController {
	private final ClasseService classeService;
	
	public ClasseController(ClasseService classeService) {
		this.classeService=classeService;
	}
	
	@PostMapping("/create/{id}")
	public Classe creer(@RequestBody Classe classe, @PathVariable Long id) {
		
		return classeService.creer(classe,id);
	}
	
	@GetMapping("/read")
	public List<Classe> read(){
		return classeService.lire();
	}
	
	@PutMapping("/update/{id}")
	public Classe update(@PathVariable Long id,@RequestBody Classe classe) {
		return classeService.modifier(id, classe);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return classeService.supprimer(id);
	}
	
	
	
	

}
