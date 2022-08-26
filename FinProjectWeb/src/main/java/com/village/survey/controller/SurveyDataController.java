package com.village.survey.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.dto.SurveyDataDTO;
import com.village.survey.entity.SurveyData;
import com.village.survey.repository.SurveyDataRepository;

@RestController
@RequestMapping("/api/administration/surveyData")
@CrossOrigin
public class SurveyDataController {

	@Autowired
	private SurveyDataRepository surveyDataRepository;

	/**
	 * This method is for save SurveyData
	 * 
	 * @param SurveyData
	 * @return
	 */
	@PostMapping("/saveSurveyData")
	public ResponseEntity<ApiStatus<SurveyData>> saveSurveyData( @RequestBody SurveyDataDTO surveyDataDto) {
		SurveyData surveyDataResponse = surveyDataRepository.save(surveyDataDto.getSurveyData());
		ApiStatus<SurveyData> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED SurveyData RECORD SUCCESSFULLY ", surveyDataResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}


	/**
	 * This method is for get all SurveyData
	 * 
	 * @return
	 */
	@GetMapping("/getAllSurveyData")
	public ResponseEntity<ApiStatus<List<SurveyData>>> getAllSurveyData() {
		List<SurveyData> surveyDataList = surveyDataRepository.findAll();
		ApiStatus<List<SurveyData>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL SurveyData RECORD SUCCESSFULLY ", surveyDataList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
