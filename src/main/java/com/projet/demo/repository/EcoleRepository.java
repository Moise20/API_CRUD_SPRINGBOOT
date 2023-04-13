package com.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.modele.Ecole;

public interface EcoleRepository extends JpaRepository<Ecole, Long> {
	

}
