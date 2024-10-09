package com.zoo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalPopulation {
	
	private BigDecimal speciesId;
	private String SpeciesName;
	private String status;
	private BigDecimal animalCount;
	private BigDecimal monthlyFoodCost;
	private BigDecimal totalMonthlyCost;

}
