package com.village.survey.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.entity.SurveyResponse;
import com.village.survey.services.SurveyResponseService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/surveyResponse")
public class SurveyResponseController {

	@Autowired
	private SurveyResponseService surveyResponseService;

	/**
	 * This method for save SurveyResponse
	 * 
	 * @param surveyResponse
	 * @return
	 */
	@PostMapping("/saveSurveyResponse")
	public ResponseEntity<ApiStatus<SurveyResponse>> saveSurveyResponse(@RequestBody SurveyResponse surveyResponse) {
		SurveyResponse surveyResponseResponse = surveyResponseService.saveSurveyResponse(surveyResponse);
		ApiStatus<SurveyResponse> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED SURVEY RESPONSE RECORD SUCCESSFULLY ", surveyResponseResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update SurveyResponse
	 * 
	 * @param surveyResponse
	 * @return
	 */
	@PutMapping("/updateSurveyResponse")
	public ResponseEntity<ApiStatus<SurveyResponse>> updateSurveyResponse(@RequestBody SurveyResponse surveyResponse) {
		SurveyResponse surveyResponseResponse = surveyResponseService.updateSurveyResponse(surveyResponse);
		ApiStatus<SurveyResponse> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE SURVEY RESPONSE RECORD SUCCESSFULLY ", surveyResponseResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get SurveyResponse by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getSurveyResponseById/{id}")
	public ResponseEntity<ApiStatus<SurveyResponse>> getSurveyResponse(@PathVariable(value = "id") Long id) {
		SurveyResponse surveyResponseResponse = surveyResponseService.getSurveyResponseById(id);
		ApiStatus<SurveyResponse> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE SURVEY RESPONSE RECORD SUCCESSFULLY ", surveyResponseResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all SurveyResponse
	 * 
	 * @return
	 */
	@GetMapping("/getAllSurveyResponse")
	public ResponseEntity<ApiStatus<List<SurveyResponse>>> getAllSurveyResponse() {
		List<SurveyResponse> surveyResponseList = surveyResponseService.getAllSurveyResponse();
		ApiStatus<List<SurveyResponse>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL SURVEY RESPONSE SUCCESSFULLY ", surveyResponseList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
