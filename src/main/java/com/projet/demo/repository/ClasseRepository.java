package com.projet.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.modele.Classe;
import com.projet.demo.modele.Ecole;

public interface ClasseRepository extends JpaRepository<Classe, Long>{

	Page<Classe> findByEcole(Ecole ecole, PageRequest pageRequest);

	List<Classe> findByNomContainingIgnoreCase(String motCle);

}
