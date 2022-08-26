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
import com.village.survey.entity.Question;
import com.village.survey.services.QuestionService;

/**
 * @author
 *
 */
@RestController
@RequestMapping("/api/administration/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	/**
	 * Returns the information of all Question
	 * 
	 * @param question
	 * @return the list of Question
	 */
	@GetMapping("/getAllQuestion")
	public ResponseEntity<ApiStatus<List<Question>>> getAllQuestion() {
		List<Question> question = questionService.getAllQuestion();
		ApiStatus<List<Question>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"SUCCESSFULLY RETURNED ALL QUESTION INFORMATION", question);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * To save a Question information
	 * 
	 * @param question
	 * @return saved Question
	 */
	@PostMapping("/saveQuestion")
	public ResponseEntity<ApiStatus<Question>> saveQuestion(@RequestBody Question question) {
		questionService.saveQuestion(question);
		ApiStatus<Question> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"SUCCESSFULLY SAVED A QUESTION INFORMATION", question);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * Returns the information of particular Question
	 * 
	 * @param id
	 * @return a particular Question
	 */
	@GetMapping("/getQuestionById/{id}")
	public ResponseEntity<ApiStatus<Question>> getQuestionById(@PathVariable("id") Long id, Question question) {
		Question questionResponse = questionService.getQuestionById(id);
		ApiStatus<Question> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"SUCCESSFULLY RETURNED A QUESTION INFORMATION", questionResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * Returns updated Question information
	 * 
	 * @param question
	 * @return updated Question
	 */
	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<ApiStatus<Question>> updateQuestion(@RequestBody Question question,Long id) {
		Question questions = questionService.updateQuestion(question, id);
		ApiStatus<Question> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"SUCCESSFULLY UPDATED A QUESTION INFORMATION", questions);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

}
