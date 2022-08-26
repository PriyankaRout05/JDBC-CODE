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

import com.village.survey.core.util.Constant;
import com.village.survey.core.util.CustomException;
import com.village.survey.dao.VillageDao;
import com.village.survey.dto.VillageDTO;
import com.village.survey.dto.VillageDistrictDTO;
import com.village.survey.entity.Village;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class VillageService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VillageDao villageDao;

	/**
	 * 
	 * @param village
	 * @return
	 */
	public Village saveVillage(Village village) {
		// TODO user id need to be loaded form user context.
		village.setCreatedUser(1L);
		village.setModifiedUser(1L);
		return villageDao.save(village);
	}

	/**
	 * This method for update village
	 * 
	 * @param state
	 * @return
	 */
	public Village updateVillage(Village village) {
		List<Village> villageList = Optional.ofNullable(villageDao.findById(village.getId()))
				.orElseThrow(() -> new CustomException(Constant.VILLAGE_NOT_FOUND_FOR_THIS_ID + village.getId()));
		Village villageDto = new Village();
		if (!villageList.isEmpty()) {
			villageDto = villageList.get(0);
			villageDto.setModifiedOn(new Date());
			villageDto.setModifiedUser(1L);
			villageDto.setName(village.getName());
			villageDto.setPincode(village.getPincode());
			villageDto = villageDao.updte(villageDto);
			logger.info("village is updted");
		}
		return villageDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Village getVillageById(Long id) {
		List<Village> villageList = Optional.ofNullable(villageDao.findById(id))
				.orElseThrow(() -> new CustomException(Constant.VILLAGE_NOT_FOUND_FOR_THIS_ID + id));
		return !villageList.isEmpty() ? villageList.get(0) : new Village();

	}

	/**
	 * This method for get all village
	 * 
	 * @return
	 */
	public List<Village> getAllVillage() {
		return villageDao.findAll().stream().parallel().sorted(Comparator.comparingLong(Village::getId).reversed())
				.collect(Collectors.toList());
	}

	public List<VillageDTO> getVillageByBranchId(Long id) {
		return villageDao.findByBranchId(id);

	}

	public VillageDistrictDTO getVillageDistrictById(Long id) {
		List<VillageDistrictDTO> villageDistrictList = Optional.ofNullable(villageDao.findByVillageId(id))
				.orElseThrow(() -> new CustomException(Constant.VILLAGE_NOT_FOUND_FOR_THIS_ID + id));
		return !villageDistrictList.isEmpty() ? villageDistrictList.get(0) : new VillageDistrictDTO();

	}

}
