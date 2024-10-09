package com.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zoo.dto.AnimalPopulation;
import com.zoo.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>{
	
	Animal findByAnimalId(int animalId);
	

}
