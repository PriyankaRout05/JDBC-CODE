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
import com.village.survey.entity.FinancialInstitutions;
import com.village.survey.services.FinancialInstitutionsService;

/**
 * @author
 *
 */
@RestController
@RequestMapping("/api/administration/financialInstitutions")
public class FinancialInstitutionsController {
	@Autowired
	private FinancialInstitutionsService financialInstitutionsService;

	/**
	 * This method for save FinancialInstitutions
	 * 
	 * @param FinancialInstitutions
	 * @return
	 */
	@PostMapping("/saveFinancialInstitutions")
	public ResponseEntity<ApiStatus<FinancialInstitutions>> saveFinancialInstitutions(
			@RequestBody FinancialInstitutions financialInstitutions) {
		FinancialInstitutions financialInstitutionsResponse = financialInstitutionsService
				.saveFinancialInstitutions(financialInstitutions);
		ApiStatus<FinancialInstitutions> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED FINANCIAL INSTITUTIONS RECORD SUCCESSFULLY ", financialInstitutionsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update FinancialInstitutions
	 * 
	 * @param FinancialInstitutions
	 * @return
	 */
	@PutMapping("/updateFinancialInstitutions")
	public ResponseEntity<ApiStatus<FinancialInstitutions>> updateFinancialInstitutions(
			@RequestBody FinancialInstitutions financialInstitutions) {
		FinancialInstitutions financialInstitutionsResponse = financialInstitutionsService
				.updateFinancialInstitutions(financialInstitutions);
		ApiStatus<FinancialInstitutions> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE FINANCIAL INSTITUTIONS RECORD SUCCESSFULLY ", financialInstitutionsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get FinancialInstitutions by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getFinancialInstitutionsById/{id}")
	public ResponseEntity<ApiStatus<FinancialInstitutions>> getFinancialInstitutions(
			@PathVariable(value = "id") Long id) {
		FinancialInstitutions financialInstitutionsResponse = financialInstitutionsService
				.getFinancialInstitutionsById(id);
		ApiStatus<FinancialInstitutions> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE FINANCIAL INSTITUTIONS RECORD SUCCESSFULLY ", financialInstitutionsResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all FinancialInstitutions
	 * 
	 * @return
	 */
	@GetMapping("/getAllFinancialInstitutions")
	public ResponseEntity<ApiStatus<List<FinancialInstitutions>>> getAllFinancialInstitutions() {
		List<FinancialInstitutions> financialInstitutionsList = financialInstitutionsService
				.getAllFinancialInstitutions();
		ApiStatus<List<FinancialInstitutions>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL FINANCIAL INSTITUTIONS RECORD SUCCESSFULLY ", financialInstitutionsList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
