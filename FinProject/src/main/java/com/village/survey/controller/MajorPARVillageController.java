package com.village.survey.controller;
//package com.village.survey.controller;
//
//import java.util.List;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.village.survey.core.util.ApiStatus;
//import com.village.survey.entity.MajorPARVillage;
//import com.village.survey.services.MajorPARVillageService;
//
//public class MajorPARVillageController {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private MajorPARVillageService majorPARVillageService;
//
//	/**
//	 * @param majorPARVillage
//	 * @return
//	 */
//	@PostMapping("/saveMajorPARVillage")
//	public ResponseEntity<ApiStatus<MajorPARVillage>> saveMajorPARVillage(
//			 @RequestBody MajorPARVillage majorPARVillage) {
//		MajorPARVillage MajorPARVillageResponse = majorPARVillageService.saveMajorPARVillage(majorPARVillage);
//		ApiStatus<MajorPARVillage> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
//				"CREATED MAJORPARVILLAGE RECORD SUCCESSFULLY ", MajorPARVillageResponse);
//		return new ResponseEntity<ApiStatus<MajorPARVillage>>(apiStatus, HttpStatus.CREATED);
//	}
//
//	/**
//	 * @param majorPARVillage
//	 * @return
//	 */
//	@PutMapping("/updateMajorPARVillage")
//	public ResponseEntity<ApiStatus<MajorPARVillage>> updateMajoMAJORPARVILLAGErPARVillage(
//			 @RequestBody MajorPARVillage majorPARVillage) {
//		MajorPARVillage majorPARVillageResponse = majorPARVillageService.updateMajorPARVillage(majorPARVillage);
//		ApiStatus<MajorPARVillage> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
//				"UPDATE MAJORPARVILLAGE  RECORD SUCCESSFULLY ", majorPARVillageResponse);
//		return new ResponseEntity<ApiStatus<MajorPARVillage>>(apiStatus, HttpStatus.CREATED);
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/getMajorPARVillageById/{id}")
//	public ResponseEntity<ApiStatus<MajorPARVillage>> getBranch(@PathVariable(value = "id") Long id) {
//		MajorPARVillage majorPARVillageResponse = majorPARVillageService.getMajorPARVillageById(id);
//		ApiStatus<MajorPARVillage> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
//				"GET SINGLE MAJORPARVILLAGE RECORD SUCCESSFULLY ", majorPARVillageResponse);
//		return new ResponseEntity<ApiStatus<MajorPARVillage>>(apiStatus, HttpStatus.OK);
//	}
//
//	/**
//	 * @return
//	 */
//	@GetMapping("/getAllMajorPARVillage")
//	public ResponseEntity<ApiStatus<List<MajorPARVillage>>> getAllMajorPARVillage() {
//		List<MajorPARVillage> majorPARVillageList = majorPARVillageService.getAllmajorPARVillage();
//		ApiStatus<List<MajorPARVillage>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
//				"GET ALL MAJORPARVILLAGE RECORD SUCCESSFULLY ", majorPARVillageList);
//		return new ResponseEntity<ApiStatus<List<MajorPARVillage>>>(apiStatus, HttpStatus.OK);
//	}
//
//}
