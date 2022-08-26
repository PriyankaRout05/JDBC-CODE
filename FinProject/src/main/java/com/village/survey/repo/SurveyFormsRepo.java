package com.village.survey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.SurveyForms;

@Repository
public interface SurveyFormsRepo extends JpaRepository<SurveyForms, Long> {

}
