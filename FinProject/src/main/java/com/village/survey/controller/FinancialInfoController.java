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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.dto.FinancialinfoDTO;
import com.village.survey.entity.FinancialInfo;
import com.village.survey.repo.FinancialInfoRepo;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/api/administration/financialInfo")
public class FinancialInfoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FinancialInfoRepo financialInfoRepo;
	
	@PostMapping("/saveFinancialInfo")
	public ResponseEntity<ApiStatus<FinancialInfo>> saveFinancialInfo( @RequestBody FinancialinfoDTO financialInfoDto) {
		FinancialInfo FinancialInfoResponse = financialInfoRepo.save(financialInfoDto.getFinancialInfo());
		ApiStatus<FinancialInfo> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED FINACILAINFO RECORD SUCCESSFULLY ", FinancialInfoResponse);
		return new ResponseEntity<ApiStatus<FinancialInfo>>(apiStatus, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
//
//	@Autowired
//	private FinancialInfoService financialInfoService;

	
	/**
	 * @param financialInfo
	 * @return
	 */
//	@PostMapping("/saveFinancialInfo")
//	public ResponseEntity<ApiStatus<FinancialInfo>> saveFinancialInfo( @RequestBody FinancialinfoDTO financialInfoDto) {
//		FinancialInfo FinancialInfoResponse = financialInfoService.save(financialInfoDto.getFinancialInfo());
//		ApiStatus<FinancialInfo> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
//				"CREATED FINACILAINFO RECORD SUCCESSFULLY ", FinancialInfoResponse);
//		return new ResponseEntity<ApiStatus<FinancialInfo>>(apiStatus, HttpStatus.CREATED);
//	}
	

//	/**
//	 * @param financialInfo
//	 * @return
//	 */
//	@PutMapping("/updateFinancialInfo")
//	public ResponseEntity<ApiStatus<FinancialInfo>> updateFinancialInfo(
//			 @RequestBody FinancialInfo financialInfo) {
//		FinancialInfo financialInfoResponse = financialInfoService.updateFinancialInfo(financialInfo);
//		ApiStatus<FinancialInfo> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
//				"UPDATE FINACIALINFO RECORD SUCCESSFULLY ", financialInfoResponse);
//		return new ResponseEntity<ApiStatus<FinancialInfo>>(apiStatus, HttpStatus.CREATED);
//	}
//
//	/**
//	 * @return
//	 */
//	@GetMapping("/getAllFinancialInfo")
//	public ResponseEntity<ApiStatus<List<FinancialInfo>>> getAllFinancialInfo() {
//		List<FinancialInfo> financialInfoList = financialInfoService.getAllfinancialInfo();
//		ApiStatus<List<FinancialInfo>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
//				"GET ALL FINACIALINFO RECORD SUCCESSFULLY ", financialInfoList);
//		return new ResponseEntity<ApiStatus<List<FinancialInfo>>>(apiStatus, HttpStatus.OK);
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/getFinancialInfoById/{id}")
//	public ResponseEntity<ApiStatus<FinancialInfo>> getFinancialInfo(@PathVariable(value = "id") Long id) {
//		FinancialInfo FinancialInfoResponse = financialInfoService.getFinancialInfoById(id);
//		ApiStatus<FinancialInfo> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
//				"GET SINGLE FINACIALINFO RECORD SUCCESSFULLY ", FinancialInfoResponse);
//		return new ResponseEntity<ApiStatus<FinancialInfo>>(apiStatus, HttpStatus.OK);
//	}

}
