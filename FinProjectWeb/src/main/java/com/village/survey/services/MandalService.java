package com.village.survey.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.core.util.CustomException;
import com.village.survey.dao.MandalDao;
import com.village.survey.dto.MandalDTO;
import com.village.survey.entity.Mandal;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class MandalService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MandalDao mandalDao;

	/**
	 * 
	 * @param Mandal
	 * @return
	 */
	public Mandal saveMandal(Mandal mandal) {
		// TODO user id need to be loaded form user context.
		mandal.setCreatedUser(1L);
		mandal.setModifiedUser(1L);
		return mandalDao.save(mandal);
	}

	/**
	 * This method for update Mandal
	 * 
	 * @param Mandal
	 * @return
	 */
	public Mandal updateMandal(Mandal mandal) {
		List<Mandal> mandalList = Optional.ofNullable(mandalDao.findById(mandal.getId()))
				.orElseThrow(() -> new CustomException("Mandal not found for this id :: " + mandal.getId()));
		Mandal mandalDto = new Mandal();
		if (!mandalList.isEmpty()) {
			mandalDto = mandalList.get(0);
			mandalDto.setModifiedOn(new Date());
			mandalDto.setModifiedUser(1L);
			mandalDto.setName(mandal.getName());
			mandalDto = mandalDao.updte(mandalDto);
			logger.info("Mandal is updted");
		}
		return mandalDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Mandal getMandalById(Long id) {
		List<Mandal> mandalList = Optional.ofNullable(mandalDao.findById(id))
				.orElseThrow(() -> new CustomException("Mandal not found for this id :: " + id));
		return !mandalList.isEmpty() ? mandalList.get(0) : new Mandal();

	}

	/**
	 * This method for get all state
	 * 
	 * @return
	 */
	public List<Mandal> getAllMandal() {
		return mandalDao.findAll().stream().parallel().sorted((v1, v2) -> v2.getId().intValue() - v1.getId().intValue())
				.collect(Collectors.toList());
	}

	public MandalDTO getMandals(Long id) {

		return mandalDao.getAllDistrictByMandalId(id);

	}

}