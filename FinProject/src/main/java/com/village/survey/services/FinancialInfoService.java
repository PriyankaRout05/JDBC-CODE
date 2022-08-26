//package com.village.survey.services;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.village.survey.core.util.CustomException;
//import com.village.survey.dao.FinancialInfoDao;
//import com.village.survey.entity.FinancialInfo;
//
//@Service
//public class FinancialInfoService {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
////	@Autowired
////	private FinancialInfoDao financialInfoDao;
////
////	
//	/**
//	 * @param financialInfo
//	 * @return
//	 */
////	public FinancialInfo saveFinancialInfo(FinancialInfo financialInfo) {
////		return financialInfoDao.save(financialInfo);
////	}
//
//	/**
//	 * @param financialInfo
//	 * @return
//	 */
//	public FinancialInfo updateFinancialInfo(FinancialInfo financialInfo) {
//		List<FinancialInfo> financialInfoList = Optional.ofNullable(financialInfoDao.findById(financialInfo.getId()))
//				.orElseThrow(
//						() -> new CustomException("financialInfo not found for this id :: " + financialInfo.getId()));
//		FinancialInfo financialInfoDto = new FinancialInfo();
//		if (!financialInfoList.isEmpty()) {
//			financialInfoDto = financialInfoList.get(0);
//			financialInfoDto.setName(financialInfo.getName());
//			financialInfoDto = financialInfoDao.updte(financialInfoDto);
//			logger.info("financialInfo is updted");
//		}
//		return financialInfoDto;
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	public FinancialInfo getFinancialInfoById(Long id) {
//		List<FinancialInfo> financialInfoList = Optional.ofNullable(financialInfoDao.findById(id))
//				.orElseThrow(() -> new CustomException("financialInfo not found for this id :: " + id));
//		return !financialInfoList.isEmpty() ? financialInfoList.get(0) : new FinancialInfo();
//
//	}
//
//	/**
//	 * @return
//	 */
//	public List<FinancialInfo> getAllfinancialInfo() {
//		return financialInfoDao.findAll().stream().parallel()
//				.sorted(Comparator.comparingLong(FinancialInfo::getId).reversed()).collect(Collectors.toList());
//	}
//
//	public FinancialInfo save(FinancialInfo financialInfo) {
//		return financialInfoDao.save(financialInfo);
//	}
//
//}
