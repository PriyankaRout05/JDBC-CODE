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
import com.village.survey.entity.VillageClassification;
import com.village.survey.services.VillageClassifictionService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/villageClassification")
public class VillageClassificationController {


	@Autowired
	private VillageClassifictionService villageClassificationService;

	/**
	 * This method for save VillageClassification
	 * 
	 * @param villageClassification
	 * @return
	 */
	@PostMapping("/saveVillageClassification")
	public ResponseEntity<ApiStatus<VillageClassification>> saveVillageClassification(
			@RequestBody VillageClassification villageClassification) {
		VillageClassification villageClassificationResponse = villageClassificationService
				.saveVillageClassification(villageClassification);
		ApiStatus<VillageClassification> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED VILLAGE CLASSIFICATION RECORD SUCCESSFULLY ", villageClassificationResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update villageClassification
	 * 
	 * @param villageClassification
	 * @return
	 */
	@PutMapping("/updateVillageClassification")
	public ResponseEntity<ApiStatus<VillageClassification>> updateVillageClassification(
			 @RequestBody VillageClassification villageClassification) {
		VillageClassification villageClassificationResponse = villageClassificationService
				.updateVillageClassification(villageClassification);
		ApiStatus<VillageClassification> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE VILLAGE CLASSIFICATION RECORD SUCCESSFULLY ", villageClassificationResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get villageClassification by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getVillageClassificationById/{id}")
	public ResponseEntity<ApiStatus<VillageClassification>> getVillageClassification(
			@PathVariable(value = "id") Long id) {
		VillageClassification villageClassificationResponse = villageClassificationService
				.getVillageClassificationById(id);
		ApiStatus<VillageClassification> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE VILLAGE CLASSIFICATION RECORD SUCCESSFULLY ", villageClassificationResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all villageClassification
	 * 
	 * @return
	 */
	@GetMapping("/getAllVillageClassification")
	public ResponseEntity<ApiStatus<List<VillageClassification>>> getAllVillageClassification() {
		List<VillageClassification> villageClassificationList = villageClassificationService
				.getAllVillageClassification();
		ApiStatus<List<VillageClassification>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL VILLAGE CLASSIFICATION RECORD SUCCESSFULLY ", villageClassificationList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
