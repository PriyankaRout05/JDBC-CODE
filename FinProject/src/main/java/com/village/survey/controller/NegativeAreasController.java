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
import com.village.survey.dto.NegativeAreasDTO;
import com.village.survey.entity.NegativeAreas;

import com.village.survey.repo.NegativeAreasRepo;

@RestController
@RequestMapping("/api/administration/NegativeAreas")
public class NegativeAreasController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	 NegativeAreasRepo  negativeAreasRepo;
	
	@PostMapping("/saveNegativeAreas")
	public ResponseEntity<ApiStatus<NegativeAreas>> saveNegativeAreas(
			@RequestBody NegativeAreasDTO  negativeAreasDTO) {
		 NegativeAreas  NegativeAreasResponse =  negativeAreasRepo.save(negativeAreasDTO.getNegativeAreas());
		ApiStatus<NegativeAreas> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED  NegativeAreas RECORD SUCCESSFULLY ", NegativeAreasResponse);
		return new ResponseEntity<ApiStatus< NegativeAreas>>(apiStatus, HttpStatus.CREATED);
}
	
	}