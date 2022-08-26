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
import com.village.survey.entity.SurveyQuestion;
import com.village.survey.services.SurveyQuestionService;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/api/administration/surveyQuestion")
public class SurveyQuestionController {

	@Autowired
	SurveyQuestionService surveyQuestionService;

	/**
	 * Returns the information of all SurveyQuestion
	 * 
	 * @param surveyQuestion
	 * @return the list of SurveyQuestion
	 */
	@GetMapping("/getAllSurveyQuestion")
	public ResponseEntity<ApiStatus<List<SurveyQuestion>>> getAllSurveyQuestion() {
		List<SurveyQuestion> surveyQuestion = surveyQuestionService.getAllSurveyQuestion();
		ApiStatus<List<SurveyQuestion>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"SUCCESSFULLY RETURNED ALL SURVEY QUESTION INFORMATION", surveyQuestion);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * To save a surveyQuestion information
	 * 
	 * @param surveyQuestion
	 * @return saved SurveyQuestion
	 */
	@PostMapping("/saveSurveyQuestion")
	public ResponseEntity<ApiStatus<SurveyQuestion>> saveSurveyQuestion(@RequestBody SurveyQuestion surveyQuestion) {
		surveyQuestionService.saveSurveyQuestion(surveyQuestion);
		ApiStatus<SurveyQuestion> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"SUCCESSFULLY SAVED A SURVEY QUESTION INFORMATION", surveyQuestion);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * Returns the information of particular surveyQuestion
	 * 
	 * @param id
	 * @return a particular surveyQuestion
	 */
	@GetMapping("/getSurveyQuestionById/{id}")
	public ResponseEntity<ApiStatus<SurveyQuestion>> getSurveyQuestionById(@PathVariable("id") long id,
			SurveyQuestion surveyQuestion) {
		SurveyQuestion surveyQuestionResponse = surveyQuestionService.getSurveyQuestionById(id);
		ApiStatus<SurveyQuestion> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"SUCCESSFULLY RETURNED A SURVEY QUESTION INFORMATION", surveyQuestionResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * Returns updated surveyQuestion information
	 * 
	 * @param surveyQuestion
	 * @return updated SurveyQuestion
	 */
	@PutMapping("/updateSurveyQuestion/{id}")
	public ResponseEntity<ApiStatus<SurveyQuestion>> updateSurveyQuestion(@RequestBody SurveyQuestion surveyQuestion,
			@PathVariable("id") long id) {
		SurveyQuestion surveyQuestions = surveyQuestionService.updateSurveyQuestion(surveyQuestion, id);
		ApiStatus<SurveyQuestion> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"SUCCESSFULLY UPDATED A SURVEY QUESTION INFORMATION", surveyQuestions);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}
}
