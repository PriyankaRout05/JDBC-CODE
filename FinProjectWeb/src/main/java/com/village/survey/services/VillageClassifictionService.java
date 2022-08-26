package com.village.survey.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.core.util.CustomException;
import com.village.survey.dao.VillageClassificationDao;
import com.village.survey.entity.VillageClassification;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class VillageClassifictionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VillageClassificationDao villageClassificationDao;

	/**
	 * 
	 * @param villageClassification
	 * @return
	 */
	public VillageClassification saveVillageClassification(VillageClassification villageClassification) {
		// TODO user id need to be loaded form user context.
		villageClassification.setCreatedUser(1L);
		villageClassification.setModifiedUser(1L);
		return villageClassificationDao.save(villageClassification);
	}

	/**
	 * This method for update villageClassification
	 * 
	 * @param state
	 * @return
	 */
	public VillageClassification updateVillageClassification(VillageClassification villageClassification) {
		List<VillageClassification> villageClassificationList = Optional
				.ofNullable(villageClassificationDao.findById(villageClassification.getId()))
				.orElseThrow(() -> new CustomException(
						"villageClassification not found for this id :: " + villageClassification.getId()));
		VillageClassification villageClassificationDto = new VillageClassification();
		if (!villageClassificationList.isEmpty()) {
			villageClassificationDto = villageClassificationList.get(0);
			villageClassificationDto.setModifiedOn(new Date());
			villageClassificationDto.setModifiedUser(1L);
			villageClassificationDto.setName(villageClassification.getName());
			villageClassificationDto = villageClassificationDao.updte(villageClassificationDto);
			logger.info("villageClassification is updted");
		}
		return villageClassificationDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public VillageClassification getVillageClassificationById(Long id) {
		List<VillageClassification> villageClassificationList = Optional
				.ofNullable(villageClassificationDao.findById(id))
				.orElseThrow(() -> new CustomException("VillageClassification not found for this id :: " + id));
		return !villageClassificationList.isEmpty() ? villageClassificationList.get(0) : new VillageClassification();

	}

	/**
	 * This method for get all villageClassification
	 * 
	 * @return
	 */
	public List<VillageClassification> getAllVillageClassification() {
		return villageClassificationDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(VillageClassification::getId).reversed()).collect(Collectors.toList());
	}

}
