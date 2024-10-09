package com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.entity.Enclosure;

@Repository
public interface EnclosureRepository extends JpaRepository<Enclosure,Integer> {

	Enclosure findByEnclosureId(int id);


}
