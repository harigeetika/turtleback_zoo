package com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.entity.Animal;
import com.zoo.entity.Species;
import com.zoo.service.AnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	

	
	@GetMapping("/allAnimals")
	public String getAllSpecies(Model model){
		model.addAttribute("animals",animalService.getAllAnimals());
		return "animal";
	}
	
	@GetMapping("/add_animal")
	public String addAnimal(){
		return "add_animal";
	}
	
	
	@PostMapping(value="/addAnimal")
	public String addAnimal(@ModelAttribute Animal a) {
		return animalService.addAnimal(a);
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String updateAnimal(@PathVariable("id") int id,Model m){
		
		m.addAttribute("ani",animalService.getAnimalById(id));
		return "edit_animal";

	}
	
	
	@PostMapping(value="/updateAnimal/{id}")
	public String updateAnimal(@PathVariable("id") int id,@ModelAttribute Animal a) {

		return animalService.updateAnimalById(id,a);
	}
	
	

	@GetMapping("/animalPopulation")
	public String animalPop(Model model){
		
		model.addAttribute("anipop",animalService.getAnimalStatistics());
		return "animal_population";
	}

}
