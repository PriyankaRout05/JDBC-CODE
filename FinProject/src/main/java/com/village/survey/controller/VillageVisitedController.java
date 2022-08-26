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
import com.village.survey.dto.VillageVisitedDTO;
import com.village.survey.entity.VillageVisited;
import com.village.survey.repo.VillageVisitedRepo;

@RestController
@RequestMapping("/api/administration/VillageVisited")
public class VillageVisitedController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	VillageVisitedRepo villageVisitedRepo;

	@PostMapping("/saveVillageVisited")
	public ResponseEntity<ApiStatus<VillageVisited>> saveVillageVisited(
			@RequestBody VillageVisitedDTO VillageVisitedDTO) {
		VillageVisited VillageVisitedResponse = villageVisitedRepo.save(VillageVisitedDTO.getVillageVisited());
		ApiStatus<VillageVisited> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED VILLAGEVISITED RECORD SUCCESSFULLY ", VillageVisitedResponse);
		return new ResponseEntity<ApiStatus<VillageVisited>>(apiStatus, HttpStatus.CREATED);

	}

}
