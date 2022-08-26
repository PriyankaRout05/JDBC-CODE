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
import com.village.survey.entity.Branch;
import com.village.survey.services.BranchService;

/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/administration/branch")
@CrossOrigin
public class BranchController {

	@Autowired
	private BranchService branchService;

	/**
	 * This method for save branch
	 * 
	 * @param branch
	 * @return
	 */
	@PostMapping("/saveBranch")
	public ResponseEntity<ApiStatus<Branch>> saveBranch(@RequestBody Branch branch) {
		Branch branchResponse = branchService.saveBranch(branch);
		ApiStatus<Branch> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"CREATED BRANCH RECORD SUCCESSFULLY ", branchResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for update Branch
	 * 
	 * @param branch
	 * @return
	 */
	@PutMapping("/updateBranch")
	public ResponseEntity<ApiStatus<Branch>> updateBranch(@RequestBody Branch branch) {
		Branch branchResponse = branchService.updateBranch(branch);
		ApiStatus<Branch> apiStatus = new ApiStatus<>(HttpStatus.CREATED, Constant.SUCCCESS,
				"UPDATE BRANCH RECORD SUCCESSFULLY ", branchResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method for get Branch by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getBranchById/{id}")
	public ResponseEntity<ApiStatus<Branch>> getBranch(@PathVariable(value = "id") Long id) {
		Branch branchResponse = branchService.getBranchById(id);
		ApiStatus<Branch> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET SINGLE BRANCH RECORD SUCCESSFULLY ", branchResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method for get all Branch
	 * 
	 * @return
	 */
	@GetMapping("/getAllBranch")
	public ResponseEntity<ApiStatus<List<Branch>>> getAllBranch() {
		List<Branch> branchList = branchService.getAllBranch();
		ApiStatus<List<Branch>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BRANCH RECORD SUCCESSFULLY ", branchList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getAllBranch/{id}")
	public ResponseEntity<ApiStatus<BranchDTO>> getAll(@PathVariable("id") Long id) {
		BranchDTO branchList = branchService.getAllDistrictByBranchId(id);
		ApiStatus<BranchDTO> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET ALL BRANCH HIERARCHY RECORD SUCCESSFULLY ", branchList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	@GetMapping("/getBranchByname/{name}")
	public ResponseEntity<ApiStatus<List<Branch>>> getBranch(@PathVariable(value = "name") String name) {
		List<Branch> branchResponse = branchService.getBranchByname(name);
		ApiStatus<List<Branch>> apiStatus = new ApiStatus<>(HttpStatus.OK, Constant.SUCCCESS,
				"GET BRANCH BY NAME RECORD SUCCESSFULLY ", branchResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}
}
