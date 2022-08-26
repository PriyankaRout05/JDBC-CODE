package com.village.survey.controller;


import java.util.List;

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
import com.village.survey.dto.VillageSurveyFromDTO;
import com.village.survey.entity.VillageSurveyFrom;
import com.village.survey.repository.VillageSurveyFromRepo;

@RestController
@RequestMapping("/api/administration/VillageSurveyFrom")
public class VillageSurveyFromController {
	
	@Autowired
	private  VillageSurveyFromRepo villageSurveyFromRepo;
	
	@PostMapping("/SaveVillageSurveyFrom")
	public ResponseEntity<ApiStatus<VillageSurveyFrom>> saveVillageSurveyFrom( @RequestBody VillageSurveyFromDTO villageSurveyFromDTO) {
		 VillageSurveyFrom  villageSurveyFromResponse = villageSurveyFromRepo.save(villageSurveyFromDTO.getVillageSurveyFrom());
		ApiStatus<VillageSurveyFrom> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED VillageSurveyFrom RECORD SUCCESSFULLY ", villageSurveyFromResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getVillageSurveyFrom")
	public ResponseEntity<ApiStatus<List<VillageSurveyFrom>>> getAllVillageSurveyFrom() {
		List<VillageSurveyFrom> villageSurveyFromList = villageSurveyFromRepo.findAll();
		ApiStatus<List<VillageSurveyFrom>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL VillageSurveyFrom RECORD SUCCESSFULLY ", villageSurveyFromList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
	
	



}
