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
import com.village.survey.entity.BranchVillages;
import com.village.survey.services.BranchVillagesService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/branchVillages")
public class BranchVillagesController {

	@Autowired
	private BranchVillagesService branchVillagesService;

	/**
	 * This method for save branchVillages
	 * 
	 * @param branchVillages
	 * @return
	 */
	@PostMapping("/saveBranchVillages")
	public ResponseEntity<ApiStatus<BranchVillages>> saveBranchVillages(@RequestBody BranchVillages branchVillages) {
		BranchVillages branchVillagesResponse = branchVillagesService.saveBranchVillages(branchVillages);
		ApiStatus<BranchVillages> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED BRANCHVILLAGES RECORD SUCCESSFULLY ", branchVillagesResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update branchVillages
	 * 
	 * @param branchVillages
	 * @return
	 */
	@PutMapping("/updateBranchVillages")
	public ResponseEntity<ApiStatus<BranchVillages>> updateBranchVillages(@RequestBody BranchVillages branchVillages) {
		BranchVillages branchVillagesResponse = branchVillagesService.updateBranchVillages(branchVillages);
		ApiStatus<BranchVillages> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE BRANCHVILLAGES RECORD SUCCESSFULLY ", branchVillagesResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get BranchVillages by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getBranchVillagesById/{id}")
	public ResponseEntity<ApiStatus<BranchVillages>> getBranchVillages(@PathVariable(value = "id") Long id) {
		BranchVillages branchVillagesResponse = branchVillagesService.getBranchVillagesById(id);
		ApiStatus<BranchVillages> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE BRANCHVILLAGES RECORD SUCCESSFULLY ", branchVillagesResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all BranchVillages
	 * 
	 * @return
	 */
	@GetMapping("/getAllBranchVillages")
	public ResponseEntity<ApiStatus<List<BranchVillages>>> getAllBranchVillages() {
		List<BranchVillages> branchVillagesList = branchVillagesService.getAllBranchVillages();
		ApiStatus<List<BranchVillages>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BRANCHVILLAGES RECORD SUCCESSFULLY ", branchVillagesList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
