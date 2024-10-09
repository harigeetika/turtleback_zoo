package com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.entity.HourlyRate;
import com.zoo.entity.Species;

@Repository
public interface HourlyRateRepository extends JpaRepository<HourlyRate, Integer>{

	HourlyRate findByHourlyrateId(int id);

}
