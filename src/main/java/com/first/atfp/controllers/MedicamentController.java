package com.first.atfp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.first.atfp.entities.Medicament;

import com.first.atfp.repositories.MedicamentRepository;

@Controller
@RequestMapping("medicament")
public class MedicamentController {
	//injection des dépendances juste avant le constructeur
	//utiliser les repositories
	private final MedicamentRepository medicamentRepository;
	@Autowired
	public MedicamentController(MedicamentRepository medicamentRepository) {
		this.medicamentRepository=medicamentRepository;
	}
	
	//faire l'affichage
	@GetMapping("list")
	public String getCategories(Model model) {
		model.addAttribute("medicaments",medicamentRepository.findAll());
		return"listMedicament";
	}
	
	//creation d'un nouveau formulaire 
	@GetMapping("add")
	public String ajouter(Model model) {
		model.addAttribute("medicament", new Medicament());
		return "addMedicament";
	}
	
	//enregistrer la catégorie dans la table
	@PostMapping("add")
	public String ajoutCat(@ModelAttribute("medicament") Medicament m) {
		medicamentRepository.save(m);
		return "redirect:list";
		
	}
	
	//supprimer une catégorie de la table
	
	@GetMapping("supprimer/{id}")
	public String supprimer(@PathVariable ("id") long id) {
		medicamentRepository.deleteById(id);
		return "redirect:../list";
	}
}
