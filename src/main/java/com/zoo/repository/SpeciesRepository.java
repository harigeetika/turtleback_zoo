package com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoo.entity.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species,Integer>{

	Species findBySpeciesId(int speciesId);
	
	int findBySpeciesName(String speciesName);
	
	@Query(value="SELECT s.speciesId FROM Species s WHERE s.speciesName=:spname")
	int findSpeciesId(@Param("spname") String spname);

}
