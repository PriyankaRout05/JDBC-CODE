package com.village.survey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.dto.SurveyFormsDTO;
import com.village.survey.entity.SurveyForms;
import com.village.survey.repo.SurveyFormsRepo;

@RestController
@RequestMapping("/api/administration/SurveyForms")
public class SurveyFormsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SurveyFormsRepo surveyFormsRepo;
	
	@PostMapping("/saveSurveyForms")
	public ResponseEntity<ApiStatus<SurveyForms>> saveSurveyForms(
			@RequestBody SurveyFormsDTO surveyFormsDTO) {
		SurveyForms SurveyFormsResponse = surveyFormsRepo.save(surveyFormsDTO.getSurveyForms());
		ApiStatus<SurveyForms> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED BRANCHSETUP RECORD SUCCESSFULLY ", SurveyFormsResponse);
		return new ResponseEntity<ApiStatus<SurveyForms>>(apiStatus, HttpStatus.CREATED);

	}
	


}
