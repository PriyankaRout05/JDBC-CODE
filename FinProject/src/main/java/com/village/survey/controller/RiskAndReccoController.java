package com.village.survey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.dto.RiskAndReccoDTO;
import com.village.survey.entity.RiskAndRecco;
import com.village.survey.repo.RiskAndReccoRepo;

@RestController
@RequestMapping("/api/administration/RiskAndRecco")
public class RiskAndReccoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RiskAndReccoRepo riskAndReccoRepo;

	@GetMapping("/getAllRiskAndRecco")
	public ResponseEntity<ApiStatus<List<RiskAndRecco>>> getAllRiskAndRecco() {
		List<RiskAndRecco> riskAndReccoResponse = riskAndReccoRepo.findAll();
		ApiStatus<List<RiskAndRecco>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET ALL RISKANDRECOMMENDATION RECORD SUCCESSFULLY ", riskAndReccoResponse);
		return new ResponseEntity<ApiStatus<List<RiskAndRecco>>>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getRiskAndReccoById/{riskAndReccoId}")
	public ResponseEntity<ApiStatus<RiskAndRecco>> getRiskAndRecco(
			@PathVariable(value = "riskAndReccoId") Long riskAndReccoId) {
		RiskAndRecco riskAndReccoResponse = riskAndReccoRepo.findById(riskAndReccoId).get();
		ApiStatus<RiskAndRecco> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET SINGLE RISKANDRECOMMENDATION RECORD SUCCESSFULLY ", riskAndReccoResponse);
		return new ResponseEntity<ApiStatus<RiskAndRecco>>(apiStatus, HttpStatus.OK);
	}

	@PostMapping("/saveRiskAndRecco")
	public ResponseEntity<ApiStatus<RiskAndRecco>> saveRiskAndRecco(@RequestBody RiskAndReccoDTO riskAndReccoDTO) {
		RiskAndRecco RiskAndReccoResponse = riskAndReccoRepo.save(riskAndReccoDTO.getRiskAndRecco());
		ApiStatus<RiskAndRecco> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"SAVE ALL RISKANDRECOMMENDATION RECORD SUCCESSFULLY ", RiskAndReccoResponse);
		return new ResponseEntity<ApiStatus<RiskAndRecco>>(apiStatus, HttpStatus.CREATED);
	}

}
