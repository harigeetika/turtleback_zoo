package com.zoo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopAttractions {
	
	private LocalDate beginDate;
	private LocalDate endDate;

}
