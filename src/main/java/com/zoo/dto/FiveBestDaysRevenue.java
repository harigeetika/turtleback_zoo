package com.zoo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FiveBestDaysRevenue {
	
	private LocalDate date;
	private long averageRevenue;
	

}
