package com.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zoo.entity.Animal;
import com.zoo.entity.Employee;
import com.zoo.entity.Species;

import com.zoo.repository.SpeciesRepository;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository repo;


	public List<Species> getAllSpecies() {
		
		return repo.findAll();
	}

	public String addSpecies(Species s) {
		repo.save(s);
		return"redirect:/species/allSpecies";
	}
	
	public String updateSpecies(int id,Species e)
	{
		Species s = repo.findBySpeciesId(id);
		
		s.setSpeciesName(e.getSpeciesName());
		s.setMonthlyFoodCost(e.getMonthlyFoodCost());
		s.setPopulation(e.getPopulation());
		repo.save(s);

		return "redirect:/species/allSpecies";

	}


	public Species getSpeciesById(int id) {
		
		return repo.findBySpeciesId(id);
	}

}
