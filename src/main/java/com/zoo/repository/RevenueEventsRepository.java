package com.zoo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoo.dto.AnimalPopulation;
import com.zoo.dto.AverageRevenueResponse;
import com.zoo.dto.FiveBestDaysRevenue;
import com.zoo.dto.RevenueBySource;
import com.zoo.dto.TopThreeAttractionsResponse;
import com.zoo.entity.RevenueEvents;
import com.zoo.entity.RevenueEventsId;

@Repository
public interface RevenueEventsRepository extends JpaRepository<RevenueEvents, RevenueEventsId> {

	
	
	
    @Query(value = "SELECT new com.zoo.dto.RevenueBySource(RE.revenueType.revenueId, RE.revenueType.revenueName, RE.revenueType.revenueType, SUM(RE.revenue) AS revenue, SUM(RE.ticketsSold) AS ticketsSold) " +
            "FROM RevenueEvents RE " +
            "WHERE RE.dateTime = :date " +
            "GROUP BY RE.revenueType.revenueId, RE.revenueType.revenueName, RE.revenueType.revenueType")
	 List<RevenueBySource> getRevenueBySourceDate(@Param("date") LocalDate date);

    
    
    @Query(value = "SELECT new com.zoo.dto.FiveBestDaysRevenue(RE.dateTime AS date, SUM(RE.revenue) AS averageRevenue) " +
            "FROM RevenueEvents RE " +
            "WHERE EXTRACT(MONTH FROM RE.dateTime) = :month AND EXTRACT(YEAR FROM RE.dateTime) = :year " +
            "GROUP BY RE.dateTime " +
            "ORDER BY averageRevenue DESC")
	Page<FiveBestDaysRevenue> getBestFiveDaysRevenue(@Param("year") int year,@Param("month") int month,Pageable pageable);
    
    
    
  


    @Query(value = "SELECT new com.zoo.dto.AverageRevenueResponse(RT.revenueName AS revenueName, AVG(RE.revenue) AS averageRevenue) " +
            "FROM RevenueEvents RE " +
            "JOIN RE.revenueType RT " +
            "WHERE RE.dateTime BETWEEN :beginDate AND :endDate " +
            "GROUP BY RT.revenueName")
	List<AverageRevenueResponse> getAverageRevenue(@Param("beginDate") LocalDate beginDate,@Param("endDate") LocalDate endDate);


    @Query(value = "SELECT new com.zoo.dto.TopThreeAttractionsResponse(RT.revenueName AS revenueName, SUM(RE.revenue) AS totalRevenue) " +
            "FROM RevenueEvents RE " +
            "JOIN RE.revenueType RT " +
            "WHERE RT.revenueType = 'Animal Show' AND RE.dateTime BETWEEN :beginDate AND :endDate " +
            "GROUP BY RT.revenueName " +
            "ORDER BY totalRevenue DESC")
	Page<TopThreeAttractionsResponse> getTopThreeAttractions(@Param("beginDate") LocalDate beginDate,@Param("endDate") LocalDate endDate, Pageable pageable);

    
    

}
