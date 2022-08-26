package com.village.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.entity.VillagePhotos;
import com.village.survey.services.VillagePhotosService;

@RestController
@RequestMapping("/api/administration/villagePhotos")
public class VillagePhotosController {


	@Autowired
	private VillagePhotosService villagePhotosService;

	/**
	 * This method for save VillagePhotos
	 * 
	 * @param VillagePhotos
	 * @return
	 */
	@PostMapping("/saveVillagePhotos")
	public ResponseEntity<ApiStatus<VillagePhotos>> saveVillagePhotos(@RequestBody VillagePhotos villagePhotos) {
		VillagePhotos villagePhotosResponse = villagePhotosService.saveVillagePhotos(villagePhotos);
		ApiStatus<VillagePhotos> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED VILLAGEPHOTOS RECORD SUCCESSFULLY ", villagePhotosResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update VillagePhotos
	 * 
	 * @param VillagePhotos
	 * @return
	 */
	@PutMapping("/updateVillagePhotos")
	public ResponseEntity<ApiStatus<VillagePhotos>> updateVillagePhotos(
			 @RequestBody VillagePhotos villagePhotos) {
		VillagePhotos villagePhotosResponse = villagePhotosService.updateVillagePhotos(villagePhotos);
		ApiStatus<VillagePhotos> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE VILLAGEPHOTOS RECORD SUCCESSFULLY ", villagePhotosResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get VillagePhotos by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getVillagePhotosById/{id}")
	public ResponseEntity<ApiStatus<VillagePhotos>> getVillagePhotos(@PathVariable(value = "id") Long id) {
		VillagePhotos villagePhotosResponse = villagePhotosService.getVillagePhotosById(id);
		ApiStatus<VillagePhotos> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE VILLAGEPHOTOS RECORD SUCCESSFULLY ", villagePhotosResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all VillagePhotos
	 * 
	 * @return
	 */
	@GetMapping("/getAllVillagePhotos")
	public ResponseEntity<ApiStatus<List<VillagePhotos>>> getAllVillagePhotos() {
		List<VillagePhotos> villagePhotosList = villagePhotosService.getAllVillagePhotos();
		ApiStatus<List<VillagePhotos>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL VILLAGEPHOTOS RECORD SUCCESSFULLY ", villagePhotosList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
