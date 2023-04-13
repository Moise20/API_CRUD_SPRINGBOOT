package com.projet.demo.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ECOLE")
@Getter
@Setter
@NoArgsConstructor
public class Ecole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=50)
	private String nom;
	@Column(length=255)
	private String description;
	
	@OneToMany(mappedBy = "ecole")
	private List<Classe> classe;
	
	// Getter  Setter pour l'attribut "nom"
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter  Setter pour l'attribut "description"
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
	public List<Classe> getClasse() {
		return classe;
	}
	public void setClasse(List<Classe> classe) {
		this.classe = classe;
	}

}
