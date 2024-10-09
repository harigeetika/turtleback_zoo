package com.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoo.entity.RevenueType;
import com.zoo.entity.ZooAdmission;

@Repository
public interface RevenueTypeRepository extends JpaRepository<RevenueType , Integer>{

	
	@Query(value="SELECT r FROM RevenueType r WHERE r.revenueType=:type")
	List<RevenueType> findRevenueType(@Param("type") String type);
	
	
	
	RevenueType findByRevenueId(int id);
	
	

}
