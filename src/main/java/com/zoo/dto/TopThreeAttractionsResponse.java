package com.zoo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopThreeAttractionsResponse {
	
	private String revenueName;
	private long totalRevenue;

}
