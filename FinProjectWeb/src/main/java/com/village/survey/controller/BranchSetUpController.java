package com.village.survey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.dto.BranchSetUpDTO;
import com.village.survey.entity.BranchSetUp;
import com.village.survey.entity.Village;
import com.village.survey.repository.BranchSetUpRepo;

@RestController
@RequestMapping("/api/administration/branchsetup")
public class BranchSetUpController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BranchSetUpRepo branchSetUpRepo;

	@PostMapping("/branchsetup")
	public ResponseEntity<ApiStatus<BranchSetUp>> saveBranchSetUp(@RequestBody BranchSetUpDTO branchSetUpDTO) {
		BranchSetUp branchSetUpResponse = branchSetUpRepo.save(branchSetUpDTO.getBranchSetUp());
		ApiStatus<BranchSetUp> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED BRANCHSETUP RECORD SUCCESSFULLY ", branchSetUpResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);

	}

	@GetMapping("/getbranchSetUp")
	public ResponseEntity<ApiStatus<List<BranchSetUp>>> getbranchSetUp() {
		List<BranchSetUp> branchList = branchSetUpRepo.getbranchSetUp();
		ApiStatus<List<BranchSetUp>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BranchSetUp RECORD SUCCESSFULLY ", branchList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
//
//	@GetMapping("/getvillagesbyblock")
//	public List<Village> getvillagesbyblock() {
//		List<Village> villagesbyblock = branchSetUpRepo.getVillagesByBlock();
//		return villagesbyblock;
//
//	}

}
