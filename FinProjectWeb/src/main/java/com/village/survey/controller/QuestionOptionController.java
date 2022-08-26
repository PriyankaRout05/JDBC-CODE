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
import com.village.survey.entity.QuestionOption;
import com.village.survey.services.QuestionOptionService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/questionOption")
public class QuestionOptionController {

	@Autowired
	private QuestionOptionService questionOptionService;

	/**
	 * This method for save QuestionOption
	 * 
	 * @param questionOption
	 * @return
	 */
	@PostMapping("/saveQuestionOption")
	public ResponseEntity<ApiStatus<QuestionOption>> saveQuestionOption(@RequestBody QuestionOption questionOption) {
		QuestionOption questionOptionResponse = questionOptionService.saveQuestionOption(questionOption);
		ApiStatus<QuestionOption> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED QUESTION OPTION RECORD SUCCESSFULLY ", questionOptionResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update QuestionOption
	 * 
	 * @param questionOption
	 * @return
	 */
	@PutMapping("/updateQuestionOption")
	public ResponseEntity<ApiStatus<QuestionOption>> updateQuestionOption(@RequestBody QuestionOption questionOption) {
		QuestionOption questionOptionResponse = questionOptionService.updateQuestionOption(questionOption);
		ApiStatus<QuestionOption> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE QUESTION OPTION RECORD SUCCESSFULLY ", questionOptionResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get QuestionOption by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getQuestionOptionById/{id}")
	public ResponseEntity<ApiStatus<QuestionOption>> getQuestionOption(@PathVariable(value = "id") Long id) {
		QuestionOption questionOptionResponse = questionOptionService.getQuestionOptionById(id);
		ApiStatus<QuestionOption> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE QUESTION OPTION RECORD SUCCESSFULLY ", questionOptionResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all QuestionOption
	 * 
	 * @return
	 */
	@GetMapping("/getAllQuestionOption")
	public ResponseEntity<ApiStatus<List<QuestionOption>>> getAllQuestionOption() {
		List<QuestionOption> questionOptionList = questionOptionService.getAllQuestionOption();
		ApiStatus<List<QuestionOption>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL QUESTION OPTION RECORD SUCCESSFULLY ", questionOptionList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
