package com.village.survey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.RiskAndRecco;

@Repository
public interface RiskAndReccoRepo extends JpaRepository<RiskAndRecco, Long> {

//	public RiskAndRecco getRiskAndReccoById(Long id);

//	 @Modifying
//	 @Query (value="select * RiskAndRecco ",nativeQuery=true)
//	 public RiskAndRecco getAllRiskAndRecco();

}
