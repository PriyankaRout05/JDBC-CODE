package com.village.survey.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import com.village.survey.dto.PremisePhotographsDTO;
import com.village.survey.entity.PremisePhotographs;
import com.village.survey.repo.PremisePhotographsRepo;

@RestController
@RequestMapping("/api/administration/premisePhotographs")
public class PremisePhotographsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PremisePhotographsRepo premisePhotographsRepo;

	@GetMapping("/getAllPhotographs")
	public ResponseEntity<ApiStatus<List<PremisePhotographs>>> getAllPhotos() {
		List<PremisePhotographs> premisePhotographsResponse = premisePhotographsRepo.findAll();
		ApiStatus<List<PremisePhotographs>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET ALL PremisePhotographs RECORD SUCCESSFULLY ", premisePhotographsResponse);
		return new ResponseEntity<ApiStatus<List<PremisePhotographs>>>(apiStatus, HttpStatus.OK);
	}

	@PostMapping("/savePhotographs")
	private ResponseEntity<ApiStatus<PremisePhotographs>> savePhto(
			@RequestBody PremisePhotographsDTO premisePhotographsDTO) {
		PremisePhotographs premisePhotographsResponse = premisePhotographsRepo
				.save(premisePhotographsDTO.getPremisePhotographs());
		ApiStatus<PremisePhotographs> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED PREMISEPHOTO  RECORD SUCCESSFULLY ", premisePhotographsResponse);
		return new ResponseEntity<ApiStatus<PremisePhotographs>>(apiStatus, HttpStatus.CREATED);
	}

}
