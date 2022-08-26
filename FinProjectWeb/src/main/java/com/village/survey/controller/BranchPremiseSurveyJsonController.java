package com.village.survey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.entity.BranchPremiseSurveyJson;
import com.village.survey.repository.BranchPremiseSurveyJsonRepo;

@RestController
@RequestMapping("/BranchPremiseSurveyJson")
public class BranchPremiseSurveyJsonController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BranchPremiseSurveyJsonRepo branchPremiseSurveyJsonRepo;

	@PostMapping("/saveBranchPremiseSurveyJson")
	public BranchPremiseSurveyJson saveBranchPremiseSurveyJson(@RequestBody BranchPremiseSurveyJson j) {
		return branchPremiseSurveyJsonRepo.save(j);

	}

	@GetMapping("/getAllBranchPremiseSurveyJson")
	public List<BranchPremiseSurveyJson> findAllBranchPremiseSurveyJson() {
		return branchPremiseSurveyJsonRepo.findAll();

	}

}
