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
import com.village.survey.entity.Panchayath;
import com.village.survey.services.PanchayathService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/panchayath")
@CrossOrigin
public class PanchayathController {

	@Autowired
	private PanchayathService panchayathService;

	/**
	 * This method for save panchayath
	 * 
	 * @param panchayath
	 * @return
	 */
	@PostMapping("/savePanchayath")
	public ResponseEntity<ApiStatus<Panchayath>> savePanchayath(@RequestBody Panchayath panchayath) {
		Panchayath panchayathResponse = panchayathService.savePanchayath(panchayath);
		ApiStatus<Panchayath> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED PANCHAYATH RECORD SUCCESSFULLY ", panchayathResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update panchayath
	 * 
	 * @param Panchayath
	 * @return
	 */
	@PutMapping("/updatePanchayath")
	public ResponseEntity<ApiStatus<Panchayath>> updatePanchayath(@RequestBody Panchayath panchayath) {
		Panchayath panchayathResponse = panchayathService.updatePanchayath(panchayath);
		ApiStatus<Panchayath> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE PANCHAYATH RECORD SUCCESSFULLY ", panchayathResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get panchayath by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getPanchayathById/{id}")
	public ResponseEntity<ApiStatus<Panchayath>> getPanchayath(@PathVariable(value = "id") Long id) {
		Panchayath panchayathResponse = panchayathService.getPanchayathById(id);
		ApiStatus<Panchayath> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE PANCHAYATH RECORD SUCCESSFULLY ", panchayathResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all panchayath
	 * 
	 * @return
	 */
	@GetMapping("/getAllPanchayath")
	public ResponseEntity<ApiStatus<List<Panchayath>>> getAllPanchayath() {
		List<Panchayath> panchayathList = panchayathService.getAllPanchayath();
		ApiStatus<List<Panchayath>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL PANCHAYATH RECORD SUCCESSFULLY ", panchayathList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
