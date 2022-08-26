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
import com.village.survey.dao.DistrictDao;
import com.village.survey.dto.MandalPincodeDTO;
import com.village.survey.entity.District;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class DistrictService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DistrictDao districtDao;

	/**
	 * 
	 * @param state
	 * @return
	 */
	public District saveDistrict(District district) {
		// TODO user id need to be loaded form user context.
		district.setCreatedUser(1L);
		district.setModifiedUser(1L);
		return districtDao.save(district);
	}

	/**
	 * This method for update district
	 * 
	 * @param state
	 * @return
	 */
	public District updateDistrict(District district) {
		List<District> districtList = Optional.ofNullable(districtDao.findById(district.getId()))
				.orElseThrow(() -> new CustomException("District not found for this id :: " + district.getId()));
		District districtDto = new District();
		if (!districtList.isEmpty()) {
			districtDto = districtList.get(0);
			districtDto.setModifiedOn(new Date());
			districtDto.setModifiedUser(1L);
			districtDto.setName(district.getName());
			districtDto = districtDao.updte(districtDto);
			logger.info("District is updted");
		}
		return districtDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public District getDistrictById(Long id) {
		List<District> districtList = Optional.ofNullable(districtDao.findById(id))
				.orElseThrow(() -> new CustomException("District not found for this id :: " + id));
		return !districtList.isEmpty() ? districtList.get(0) : new District();

	}

	/**
	 * This method for get all district
	 * 
	 * @return
	 */
	public List<District> getAllDistrict() {
		return districtDao.findAll().stream().sorted(Comparator.comparingLong(District::getId).reversed())
				.collect(Collectors.toList());
	}
	
	public List<District> getDistrictByState(List<Long> state){
		return districtDao.findByState(state);
		
	}

	public List<MandalPincodeDTO> getDistrictDetailsById(Long id) {
		return districtDao.findByDistrictId(id);
	}

}
