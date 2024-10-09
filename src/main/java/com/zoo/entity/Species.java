package com.zoo.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="species")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Species {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int speciesId;
	private String speciesName;
	private int population;
	private int monthlyFoodCost;
	
	
}
