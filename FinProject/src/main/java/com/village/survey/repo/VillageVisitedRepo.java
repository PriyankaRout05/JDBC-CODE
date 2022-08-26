package com.village.survey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.VillageVisited;

@Repository
public interface VillageVisitedRepo extends JpaRepository<VillageVisited, Integer> {
	
	

}
