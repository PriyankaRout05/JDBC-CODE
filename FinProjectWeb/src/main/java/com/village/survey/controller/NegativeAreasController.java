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
import com.village.survey.entity.NegativeAreas;
import com.village.survey.services.NegativeAreasService;

@RestController
@RequestMapping("/api/administration/negativeareas")
@CrossOrigin
public class NegativeAreasController {

	@Autowired
	private NegativeAreasService negativeAreasService;

	/**
	 * This method for save negativeareas
	 * 
	 * @param negativeareas
	 * @return
	 */
	@PostMapping("/saveNegativeAreas")
	public ResponseEntity<ApiStatus<NegativeAreas>> saveNegativeAreas(@RequestBody NegativeAreas negativeAreas) {
		NegativeAreas negativeAreasResponse = negativeAreasService.saveNegativeAreas(negativeAreas);
		ApiStatus<NegativeAreas> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED NegativeAreas RECORD SUCCESSFULLY ", negativeAreasResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update negativeareas
	 * 
	 * @param negativeareas
	 * @return
	 */
	@PutMapping("/updateNegativeAreas")
	public ResponseEntity<ApiStatus<NegativeAreas>> updateNegativeAreas(@RequestBody NegativeAreas negativeAreas) {
		NegativeAreas negativeAreasResponse = negativeAreasService.updateNegativeAreas(negativeAreas);
		ApiStatus<NegativeAreas> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE NegativeAreas RECORD SUCCESSFULLY ", negativeAreasResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get NegativeAreas by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getNegativeAreasById/{id}")
	public ResponseEntity<ApiStatus<NegativeAreas>> getNegativeAreas(@PathVariable(value = "id") Long id) {
		NegativeAreas negativeAreasResponse = negativeAreasService.getNegativeAreasById(id);
		ApiStatus<NegativeAreas> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE NegativeAreas RECORD SUCCESSFULLY ", negativeAreasResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all NegativeAreas
	 * 
	 * @return
	 */
	@GetMapping("/getAllNegativeAreas")
	public ResponseEntity<ApiStatus<List<NegativeAreas>>> getAllNegativeAreas() {
		List<NegativeAreas> negativeAreasList = negativeAreasService.getAllNegativeAreas();
		ApiStatus<List<NegativeAreas>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL NegativeAreas RECORD SUCCESSFULLY ", negativeAreasList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
