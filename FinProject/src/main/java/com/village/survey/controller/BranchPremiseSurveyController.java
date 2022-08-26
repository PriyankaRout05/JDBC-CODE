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
import com.village.survey.dto.BranchPremiseSurveyDTO;
import com.village.survey.entity.BranchPremiseSurvey;
import com.village.survey.entity.RiskAndRecco;
import com.village.survey.repo.BranchPremiseSurveyRepo;

@RestController
@RequestMapping("/api/administration/BranchPremiseSurvey")
public class BranchPremiseSurveyController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BranchPremiseSurveyRepo branchPremiseSurveyRepo;

	@PostMapping("/saveBranchPremiseSurvey")
	private ResponseEntity<ApiStatus<BranchPremiseSurvey>> saveBranchPremiseSurvey(
			@RequestBody BranchPremiseSurveyDTO branchPremiseSurveyDTO) {
		BranchPremiseSurvey BranchPremiseSurveyResponse = branchPremiseSurveyRepo
				.save(branchPremiseSurveyDTO.getBranchPremiseSurvey());
		ApiStatus<BranchPremiseSurvey> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED BRANCHPREMISE SURVEY RECORD SUCCESSFULLY ", BranchPremiseSurveyResponse);
		return new ResponseEntity<ApiStatus<BranchPremiseSurvey>>(apiStatus, HttpStatus.CREATED);
	}


	@GetMapping("/getAllBranchPremiseSurvey")
	public ResponseEntity<ApiStatus<List<BranchPremiseSurvey>>> findAllBranchPremiseSurveys() {
		List<BranchPremiseSurvey> branchPremiseSurveyResponse = branchPremiseSurveyRepo.findAll();
		ApiStatus<List<BranchPremiseSurvey>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET ALL BRANCHPREMISE SURVEY RECORD SUCCESSFULLY ", branchPremiseSurveyResponse);
		return new ResponseEntity<ApiStatus<List<BranchPremiseSurvey>>>(apiStatus, HttpStatus.OK);

	}

	
//	@GetMapping("/getAllBranchPremiseSurvey")
//	public List<BranchPremiseSurvey> findAllBranchPremiseSurveys() {
//		return branchPremiseSurveyRepo.findAll();
//
//	}
}
