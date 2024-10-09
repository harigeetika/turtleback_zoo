package com.zoo.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="animal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int animalId;
	private String animalName;
	private String gender; 
	private String status;
	private int birthYear;
	private int buildingId;
	private int enclosureId;
	private int speciesId;

	
}
