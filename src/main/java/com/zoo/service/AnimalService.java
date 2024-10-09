package com.zoo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zoo.dto.AnimalPopulation;
import com.zoo.entity.Animal;
import com.zoo.entity.Building;
import com.zoo.repository.AnimalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repo;
	


	public String deleteAnimalById(int animalId) {
		Animal ani = repo.findByAnimalId(animalId);
		repo.deleteById(animalId);
		return "Animal with "+animalId+" deleted succesfully";
		
	}


	public List<Animal> getAllAnimals() {
		return repo.findAll();
	}


	public String addAnimal(Animal a) {
		repo.save(a);
		return "redirect:/animal/allAnimals";
	}


	public Animal getAnimalById(int id) {
		return repo.findByAnimalId(id);
	}


	public String updateAnimalById(int id, Animal a) {
		
		Animal p = repo.findByAnimalId(id);
		
		p.setAnimalName(a.getAnimalName());
		p.setBirthYear(a.getBirthYear());
		p.setBuildingId(a.getBuildingId());
		p.setGender(a.getGender());
		p.setSpeciesId(a.getSpeciesId());
		p.setStatus(a.getStatus());
		p.setEnclosureId(a.getEnclosureId());
		repo.save(p);
		return "redirect:/animal/allAnimals";
	}
	
	
	
	@PersistenceContext
    private EntityManager entityManager;

    public List<AnimalPopulation> getAnimalStatistics() {
    	
    	
    	
    	List<AnimalPopulation> animalPopulation = new ArrayList<AnimalPopulation>();
        String sqlQuery =
        		
        "SELECT A.SPECIES_ID, S.SPECIES_NAME AS Species_Name,A.STATUS,COUNT(A.ANIMAL_ID) AS AnimalCount,SUM(S.MONTHLY_FOOD_COST) As TotalFoodCost," +
        "AVG(care_costs.TotalMonthlyCost) AS TotalMonthlyCost " +
        "FROM Animal A "+
        "JOIN Species S ON A.SPECIES_ID = S.SPECIES_ID " +
        "LEFT JOIN(SELECT cf.SPECIES_ID, SUM(hr.RATE *4*40) AS TotalMonthlyCost " +
        "          FROM CARES_FOR cf " +
        "          JOIN EMPLOYEE e ON cf.EMP_ID = e.EMP_ID " +
        "          JOIN HOURLY_RATE hr ON e.HOURLYRATE_ID = hr.HOURLYRATE_ID " +
        "          GROUP BY cf.SPECIES_ID) " +
        "care_costs ON A.SPECIES_ID = care_costs.SPECIES_ID " +
        "GROUP BY A.SPECIES_ID,S.SPECIES_NAME,A.STATUS";
        
        Query query = entityManager.createNativeQuery(sqlQuery);
        List<Object[]> result = query.getResultList();
        
        for (Object[] row : result) {
            
        	AnimalPopulation a = new AnimalPopulation();
        	a.setSpeciesId((BigDecimal) row[0]);
        	a.setSpeciesName((String) row[1]);
        	a.setStatus((String) row[2]);
        	a.setAnimalCount((BigDecimal) row[3]);
        	a.setMonthlyFoodCost((BigDecimal) row[4]);
        	a.setTotalMonthlyCost((BigDecimal) row[5]);
        	
        	animalPopulation.add(a);
        }
        
        return animalPopulation;
    }
}
