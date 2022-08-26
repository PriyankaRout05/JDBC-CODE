package com.village.survey.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.entity.State;
import com.village.survey.services.StateService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/state")
@CrossOrigin
public class StateController {

	@Autowired
	private StateService stateService;

	/**
	 * This method for save State
	 * 
	 * @param state
	 * @return
	 */
	@PostMapping("/saveState")
	public ResponseEntity<ApiStatus<State>> saveState(@RequestBody State state) {
		State stateResponse = stateService.saveState(state);
		ApiStatus<State> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED STATE RECORD SUCCESSFULLY ", stateResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update State
	 * 
	 * @param state
	 * @return
	 */
	@PutMapping("/updateState")
	public ResponseEntity<ApiStatus<State>> updateState(@RequestBody State state) {
		State stateResponse = stateService.updateState(state);
		ApiStatus<State> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE STATE RECORD SUCCESSFULLY ", stateResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get state based on id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getStateById/{id}")
	public ResponseEntity<ApiStatus<State>> getState(@PathVariable(value = "id") Long id) {
		State stateResponse = stateService.getState(id);
		ApiStatus<State> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE STATE RECORD SUCCESSFULLY ", stateResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all state
	 * 
	 * @return
	 */
	@GetMapping("/getAllState")
	public ResponseEntity<ApiStatus<List<State>>> getAllState() {
		List<State> stateList = stateService.getAllState();
		ApiStatus<List<State>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL STATE RECORD SUCCESSFULLY ", stateList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
