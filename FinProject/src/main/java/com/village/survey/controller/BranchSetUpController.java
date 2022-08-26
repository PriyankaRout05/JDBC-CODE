package com.village.survey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.dto.BranchSetUpDTO;
import com.village.survey.entity.BranchSetUp;
import com.village.survey.repo.BranchSetUpRepo;


@RestController
@RequestMapping("/api/administration/branchsetup")
public class BranchSetUpController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BranchSetUpRepo branchSetUpRepo;

	@PostMapping("/branchsetup")
	public ResponseEntity<ApiStatus<BranchSetUp>> saveBranchSetUp(
			@RequestBody BranchSetUpDTO BranchSetUpDTO) {
		BranchSetUp BranchSetUpResponse = branchSetUpRepo.save(BranchSetUpDTO.getBranchSetUp());
		ApiStatus<BranchSetUp> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED BRANCHSETUP RECORD SUCCESSFULLY ", BranchSetUpResponse);
		return new ResponseEntity<ApiStatus<BranchSetUp>>(apiStatus, HttpStatus.CREATED);

	}

}
