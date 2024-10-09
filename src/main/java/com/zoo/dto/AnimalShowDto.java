package com.zoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalShowDto {
	
	
	private int revenueId;
	private String revneueName;
	private int buildingId;
	private int seniorPrice;
	private int adultPrice;
	private int childPrice;
	private int showsPerDay;

}
