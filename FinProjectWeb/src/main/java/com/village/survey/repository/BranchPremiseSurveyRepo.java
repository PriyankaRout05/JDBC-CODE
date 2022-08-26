package com.village.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.BranchPremiseSurvey;


@Repository
public interface BranchPremiseSurveyRepo extends JpaRepository<BranchPremiseSurvey, Long> {
//
//	@Query(value = "select n.name as negativeareas,r.ring_leader as ringleaders,noc.negative_occupation_name as negativeoccupations,ri.other as others from survey_forms s\n"
//			+ "inner join negative_areas n on negative_id = n.branch_id\n"
//			+ "inner join ring_leaders r on ring_leaders_id = r.branch_id\n"
//			+ "inner join riskrelated_information ri on riskrelatedinfo_id = ri.branch_id\n"
//			+ "inner join negative_occupation noc on negative_occupation_id = noc.branch_id", nativeQuery = true)
//	public List<BranchPremiseSurvey> getBranchPremiseSurvey();

//	@Query(value = "select r.question as coverage_mfis,r.value as rms_rating,r2.business_enviorment_rating as business_environmet_rating,r2.rms_recommendation as\n"
//			+ "rms_recommendation from  risk_recommendation rr\n"
//			+ "inner join  rating r on r.rating_id = rr.branch_id\n"
//			+ "inner join risk_recommendation r2 on rr.riskrecom_id =rr.branch_id", nativeQuery = true)
//	public List<RiskRecommendation> getRiskRecommendation();
//
//	
		
}
