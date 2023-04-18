package com.projet.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.modele.Classe;
import com.projet.demo.service.ClasseService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/classe")
public class ClasseController {
	private final ClasseService classeService;
	
	public ClasseController(ClasseService classeService) {
		this.classeService=classeService;
	}
	
	@PostMapping("/create-ten-class/{id}")
	public List<Classe> creerClassesPourEcole(@PathVariable Long id) {
		
	    return classeService.creerPlusieursClasses(id);
	}

	
	@PostMapping("/create/{id}")
	public Classe creer(@RequestBody Classe classe, @PathVariable Long id) {
		
		return classeService.creer(classe,id);
	}
	
//	@GetMapping("/read")
//	public List<Classe> read(){
//		return classeService.lire();
//	}
	
	@GetMapping("/read")
	public Page<Classe> classesPage(@RequestParam(defaultValue = "0") int page,
	                          @RequestParam(defaultValue = "5") int size,
	                          org.springframework.ui.Model model) {
	    Page<Classe> classesPage = classeService.lire(page, size);
	    List<Classe> classes = classesPage.getContent();
	    int totalPages = classesPage.getTotalPages();
	    model.addAttribute("classes", classes);
	    model.addAttribute("totalPages", totalPages);
	    return classeService.lire( page,  size);
	}
	
	
	@GetMapping("/ecoles/{id}/classes")
	public Page<Classe> getClassesByEcole(@PathVariable Long id,
	                                      @RequestParam(defaultValue = "0") int page,
	                                      @RequestParam(defaultValue = "5") int size) {
	   
	    return classeService.lireClasseParEcole(id, page,size);
	}
	
	@GetMapping("/search")
	public List<Classe> chercherClassesParMotCle(@RequestParam("motCle") String motCle) {
	    return classeService.findByNomContainingIgnoreCase(motCle);
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
