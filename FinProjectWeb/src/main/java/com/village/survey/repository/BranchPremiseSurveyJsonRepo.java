package com.village.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.BranchPremiseSurveyJson;

@Repository
public interface BranchPremiseSurveyJsonRepo extends JpaRepository<BranchPremiseSurveyJson, Long> {

}
