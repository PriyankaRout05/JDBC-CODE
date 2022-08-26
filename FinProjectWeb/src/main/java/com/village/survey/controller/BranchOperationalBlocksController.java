package com.village.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.core.util.Constant;
import com.village.survey.dto.BranchDTO;
import com.village.survey.entity.BranchOperationalBlocks;
import com.village.survey.services.BranchOperationalBlocksService;

@RestController
@RequestMapping("/api/administration/branchOperationalBlocks")
@CrossOrigin
public class BranchOperationalBlocksController {

	@Autowired
	private BranchOperationalBlocksService branchOperationalBlocksService;

	/**
	 * This method for save branchOperationalBlocks
	 * 
	 * @param branchOperationalBlocks
	 * @return
	 */
	@PostMapping("/saveBranchOperationalBlocks")
	public ResponseEntity<ApiStatus<BranchOperationalBlocks>> saveBranchOperationalBlocks(
			@RequestBody BranchOperationalBlocks branchOperationalBlocks) {
		BranchOperationalBlocks branchOperationalBlocksresponse = branchOperationalBlocksService
				.saveBranchOperationalBlocks(branchOperationalBlocks);
		ApiStatus<BranchOperationalBlocks> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED BRANCHOPERATIONALBLOCKS RECORD SUCCESSFULLY ", branchOperationalBlocksresponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update BranchoperationalBlocks
	 *
	 * @param branchOperationalBlocks
	 * @return
	 */
	@PutMapping("/updateBranchOperationalBlocks")
	public ResponseEntity<ApiStatus<BranchOperationalBlocks>> updateBranchOperationalBlocks(
			@RequestBody BranchOperationalBlocks branchOperationalBlocks) {
		BranchOperationalBlocks brancOperationalBlocksResponse = branchOperationalBlocksService
				.updateBranchOperationalBlocks(branchOperationalBlocks);
		ApiStatus<BranchOperationalBlocks> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATED BRANCHOPERATIONALBLOCKS RECORD SUCCESSFULLY ", brancOperationalBlocksResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get BranchOperationalBlocks by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getBranchOperationalBlocksById/{id}")
	public ResponseEntity<ApiStatus<BranchOperationalBlocks>> getBranchOperationalBlocks(
			@PathVariable(value = "id") Long id) {
		BranchOperationalBlocks brancOperationalBlocksResponse = branchOperationalBlocksService
				.getBranchOperationalBlocksById(id);
		ApiStatus<BranchOperationalBlocks> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE BRANCHOPERATIONALBLOCKS RECORD SUCCESSFULLY ", brancOperationalBlocksResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all BranchOpeartionalBlocks
	 * 
	 * @return
	 */
	@GetMapping("/getAllBranchOperationalBlocks")
	public ResponseEntity<ApiStatus<List<BranchOperationalBlocks>>> getAllBranchOperationalBlocks() {
		List<BranchOperationalBlocks> branchOperationalBlocksList = branchOperationalBlocksService
				.getAllBranchOperationalBlocks();
		ApiStatus<List<BranchOperationalBlocks>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BRANCHOPERATIONALBLOCKS RECORD SUCCESSFULLY ", branchOperationalBlocksList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getAllBranchOperationalBlocks/{id}")
	public ResponseEntity<ApiStatus<BranchDTO>> getAll(@PathVariable("id") Long id) {
		BranchDTO branchList = branchOperationalBlocksService.getAllBranchOperationalBlocksById(id);
		ApiStatus<BranchDTO> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BRANCH RECORD SUCCESSFULLY ", branchList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
}
