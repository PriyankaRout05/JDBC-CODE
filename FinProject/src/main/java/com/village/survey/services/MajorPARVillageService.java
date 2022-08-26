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
//import com.village.survey.core.util.CustomException;
//import com.village.survey.dao.MajorPARVillageDao;
//import com.village.survey.entity.MajorPARVillage;
//
//public class MajorPARVillageService {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	/**
//	 * 
//	 */
//	@Autowired
//	private MajorPARVillageDao majorPARVillageDao;
//
//	public MajorPARVillage saveMajorPARVillage(MajorPARVillage majorPARVillage) {
//		return majorPARVillageDao.save(majorPARVillage);
//	}
//
//	/**
//	 * @param majorPARVillage
//	 * @return
//	 */
//	public MajorPARVillage updateMajorPARVillage(MajorPARVillage majorPARVillage) {
//
//		List<MajorPARVillage> majorPARVillageList = Optional
//				.ofNullable(majorPARVillageDao.findById(majorPARVillage.getId())).orElseThrow(() -> new CustomException(
//						"MajorPARVillage not found for this id :: " + majorPARVillage.getId()));
//		MajorPARVillage majorPARVillageDto = new MajorPARVillage();
//		if (!majorPARVillageList.isEmpty()) {
//			majorPARVillageDto = majorPARVillageList.get(0);
//			majorPARVillageDto.setName(majorPARVillage.getName());
//			majorPARVillageDto = majorPARVillageDao.updte(majorPARVillageDto);
//			logger.info("majorPARVillage updted");
//		}
//		return majorPARVillage;
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	public MajorPARVillage getMajorPARVillageById(Long id) {
//		List<MajorPARVillage> majorPARVillageList = Optional.ofNullable(majorPARVillageDao.findById(id))
//				.orElseThrow(() -> new CustomException("MajorPARVillage not found for this id :: " + id));
//		return !majorPARVillageList.isEmpty() ? majorPARVillageList.get(0) : new MajorPARVillage();
//
//	}
//
//	/**
//	 * @return
//	 */
//	public List<MajorPARVillage> getAllmajorPARVillage() {
//
//		return majorPARVillageDao.findAll().stream().parallel()
//				.sorted(Comparator.comparingLong(MajorPARVillage::getId).reversed()).collect(Collectors.toList());
//	}
//}
