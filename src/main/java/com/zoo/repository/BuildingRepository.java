package com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoo.entity.Building;
import com.zoo.entity.Enclosure;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer>{
	
	Building findByBuildingId(int buildingId);
	
	
	@Query(value="SELECT s.buildingId FROM Building s WHERE s.buildingName=:bname")
	int findBuildingId(@Param("bname") String bname);

}
