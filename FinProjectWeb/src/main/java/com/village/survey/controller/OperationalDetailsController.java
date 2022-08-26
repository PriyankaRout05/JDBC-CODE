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
import com.village.survey.entity.OperationalDetails;
import com.village.survey.services.OperationalDetailsService;

@RestController
@RequestMapping("/api/administration/operationalDetails")
public class OperationalDetailsController {

	@Autowired
	private OperationalDetailsService operationalDetailsService;

	/**
	 * This method for save OperationalDetails
	 * 
	 * @param OperationalDetails
	 * @return
	 */
	@PostMapping("/saveOperationalDetails")
	public ResponseEntity<ApiStatus<OperationalDetails>> saveOperationalDetails(
			@RequestBody OperationalDetails operationalDetails) {
		OperationalDetails operationalDetailsResponse = operationalDetailsService
				.saveOperationalDetails(operationalDetails);
		ApiStatus<OperationalDetails> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED OPERATIONAL DETAILS RECORD SUCCESSFULLY ", operationalDetailsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update OperationalDetails
	 * 
	 * @param OperationalDetails
	 * @return
	 */
	@PutMapping("/updateOperationalDetails")
	public ResponseEntity<ApiStatus<OperationalDetails>> updateOperationalDetails(
			@RequestBody OperationalDetails operationalDetails) {
		OperationalDetails operationalDetailsResponse = operationalDetailsService
				.updateOperationalDetails(operationalDetails);
		ApiStatus<OperationalDetails> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE OPERATIONAL DETAILS RECORD SUCCESSFULLY ", operationalDetailsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get OperationalDetails by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getOperationalDetailsById/{id}")
	public ResponseEntity<ApiStatus<OperationalDetails>> getOperationalDetails(@PathVariable(value = "id") Long id) {
		OperationalDetails operationalDetailsResponse = operationalDetailsService.getOperationalDetailsById(id);
		ApiStatus<OperationalDetails> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE OPERATIONAL DETAILS RECORD SUCCESSFULLY ", operationalDetailsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all OperationalDetails
	 * 
	 * @return
	 */
	@GetMapping("/getAllOperationalDetails")
	public ResponseEntity<ApiStatus<List<OperationalDetails>>> getAllOperationalDetails() {
		List<OperationalDetails> operationalDetailsList = operationalDetailsService.getAllOperationalDetails();
		ApiStatus<List<OperationalDetails>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL OPERATIONAL DETAILS RECORD SUCCESSFULLY ", operationalDetailsList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
