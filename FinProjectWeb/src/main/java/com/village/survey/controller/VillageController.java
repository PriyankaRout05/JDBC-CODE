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
import com.village.survey.dto.VillageDTO;
import com.village.survey.dto.VillageDistrictDTO;
import com.village.survey.entity.Village;
import com.village.survey.repository.VillageRepo;
import com.village.survey.services.VillageService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/village")
@CrossOrigin
public class VillageController {

	@Autowired
	private VillageService villageService;
	
	@Autowired
	private VillageRepo villageRepo;

	/**
	 * This method for save village
	 * 
	 * @param village/
	 * @return
	 */
	@PostMapping("/saveVillage")
	public ResponseEntity<ApiStatus<Village>> saveVillage(@RequestBody Village village) {
		Village villageResponse = villageService.saveVillage(village);
		ApiStatus<Village> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED VILLAGE R/ECORD SUCCESSFULLY ", villageResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update village
	 * 
	 * @param village
	 * @return
	 */
	@PutMapping("/updateVillage")
	public ResponseEntity<ApiStatus<Village>> updateVillage(@RequestBody Village village) {
		Village villageResponse = villageService.updateVillage(village);
		ApiStatus<Village> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE VILLAGE RECORD SUCCESSFULLY ", villageResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get village by id
	 * 
	private static final long serialVersionUID = 1L;
	 * @param id
	 * @return
	 */
	@GetMapping("/getVillageById/{id}")
	public ResponseEntity<ApiStatus<Village>> getVillage(@PathVariable(value = "id") Long id) {
		Village villageResponse = villageService.getVillageById(id);
		ApiStatus<Village> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE VILLAGE RECORD SUCCESSFULLY ", villageResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all village
	 * 
	 * @return
	 */
	@GetMapping("/getAllVillage")
	public ResponseEntity<ApiStatus<List<Village>>> getAllVillage() {
		List<Village> villageList = villageService.getAllVillage();
		ApiStatus<List<Village>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL VILLAGE RECORD SUCCESSFULLY ", villageList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
	
	@GetMapping("/getVillageByBranchId/{id}")
	public ResponseEntity<ApiStatus<List<VillageDTO>>> getVillageByBranchId(@PathVariable(value = "id") Long id) {
		List<VillageDTO> villageResponse = villageService.getVillageByBranchId(id);
		ApiStatus<List<VillageDTO>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE VILLAGE BY BRANCH ID RECORD SUCCESSFULLY ", villageResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getVillageByDistrictId/{id}")
	public ResponseEntity<ApiStatus<VillageDistrictDTO>> getVillageDistrict(@PathVariable(value = "id") Long id) {
		VillageDistrictDTO villageResponse = villageService.getVillageDistrictById(id);
		ApiStatus<VillageDistrictDTO> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE VILLAGE  BY DISTRICT ID RECORD SUCCESSFULLY ", villageResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
	
	@GetMapping("/getvillagesbyblock/{id}")
	public List<Village> getvillagesbyblock(@PathVariable(value="id") long id) {
		return villageRepo.getVillagesByBlock(id);
	
	}

}
