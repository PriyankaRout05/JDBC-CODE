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
import com.village.survey.dto.MandalPincodeDTO;
import com.village.survey.entity.District;
import com.village.survey.services.DistrictService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/district")
@CrossOrigin
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	/**
	 * This method for save district
	 * 
	 * @param district
	 * @return
	 */
	@PostMapping("/saveDistrict")
	public ResponseEntity<ApiStatus<District>> saveDistrict(@RequestBody District district) {
		District districtResponse = districtService.saveDistrict(district);
		ApiStatus<District> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED DISTRICT RECORD SUCCESSFULLY ", districtResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update district
	 * 
	 * @param district
	 * @return
	 */
	@PutMapping("/updateDistrict")
	public ResponseEntity<ApiStatus<District>> updateDistrict(@RequestBody District district) {
		District districtResponse = districtService.updateDistrict(district);
		ApiStatus<District> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE DISTRICT RECORD SUCCESSFULLY ", districtResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get district by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getDistrictById/{id}")
	public ResponseEntity<ApiStatus<District>> getDistrict(@PathVariable(value = "id") Long id) {
		District districtResponse = districtService.getDistrictById(id);
		ApiStatus<District> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE DISTRICT RECORD SUCCESSFULLY ", districtResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all district
	 * 
	 * @return
	 */
	@GetMapping("/getAllDistrict")
	public ResponseEntity<ApiStatus<List<District>>> getAllDistrict() {
		List<District> districtList = districtService.getAllDistrict();
		ApiStatus<List<District>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL DISTRICT RECORD SUCCESSFULLY ", districtList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@PostMapping("/getDistrictByState")
	public ResponseEntity<ApiStatus<List<District>>> getDistrictDetails(@RequestBody List<Long> stateIds) {
		List<District> districtResponse = districtService.getDistrictByState(stateIds);
		ApiStatus<List<District>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL DISTRICT BY STATE RECORD SUCCESSFULLY ", districtResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getDistrictDetails/{id}")
	public ResponseEntity<ApiStatus<List<MandalPincodeDTO>>> getDistrictDetails(@PathVariable(value = "id") Long id) {
		List<MandalPincodeDTO> districtResponse = districtService.getDistrictDetailsById(id);
		ApiStatus<List<MandalPincodeDTO>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE DISTRICT RECORD SUCCESSFULLY ", districtResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
