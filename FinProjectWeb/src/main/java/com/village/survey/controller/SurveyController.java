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
import com.village.survey.entity.Survey;
import com.village.survey.services.SurveyService;

@RestController
@RequestMapping("/api/administration/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	/**
	 * This method for save Survey
	 *
	 * @param Survey
	 * @return
	 */
	@PostMapping("/saveSurvey")
	public ResponseEntity<ApiStatus<Survey>> saveSurvey(@RequestBody Survey survey) {
		Survey surveyResponse = surveyService.saveSurvey(survey);
		ApiStatus<Survey> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED SURVEY RECORD SUCCESSFULLY ", surveyResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update Survey
	 *
	 * @param Survey
	 * @return
	 */
	@PutMapping("/updateSurvey")
	public ResponseEntity<ApiStatus<Survey>> updateSurvey(@RequestBody Survey survey) {
		Survey surveyResponse = surveyService.updateSurvey(survey);
		ApiStatus<Survey> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE SURVEY RECORD SUCCESSFULLY ", surveyResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get Survey by id
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/getSurveyById/{id}")
	public ResponseEntity<ApiStatus<Survey>> getSurvey(@PathVariable(value = "id") Long id) {
		Survey surveyResponse = surveyService.getSurveyById(id);
		ApiStatus<Survey> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE SURVEY RECORD SUCCESSFULLY ", surveyResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all Survey
	 *
	 * @return
	 */
	@GetMapping("/getAllSurvey")
	public ResponseEntity<ApiStatus<List<Survey>>> getAllSurvey() {
		List<Survey> surveyList = surveyService.getAllSurvey();
		ApiStatus<List<Survey>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL SURVEY RECORD SUCCESSFULLY ", surveyList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
}
