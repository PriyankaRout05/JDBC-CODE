package com.village.survey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.FinancialInfo;
@Repository
public interface FinancialInfoRepo extends JpaRepository<FinancialInfo, Integer> {
	

}
