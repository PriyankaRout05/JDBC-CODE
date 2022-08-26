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
import com.village.survey.dao.PanchayathDao;
import com.village.survey.entity.Panchayath;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class PanchayathService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PanchayathDao panchayathDao;

	/**
	 * 
	 * @param panchayath
	 * @return
	 */
	public Panchayath savePanchayath(Panchayath panchayath) {
		// TODO user id need to be loaded form user context.
		panchayath.setCreatedUser(1L);
		panchayath.setModifiedUser(1L);
		return panchayathDao.save(panchayath);
	}

	/**
	 * This method for update panchayath
	 * 
	 * @param state
	 * @return
	 */
	public Panchayath updatePanchayath(Panchayath panchayath) {
		List<Panchayath> panchayathList = Optional.ofNullable(panchayathDao.findById(panchayath.getId()))
				.orElseThrow(() -> new CustomException("Panchayath not found for this id :: " + panchayath.getId()));
		Panchayath panchayathDto = new Panchayath();
		if (!panchayathList.isEmpty()) {
			panchayathDto = panchayathList.get(0);
			panchayathDto.setModifiedOn(new Date());
			panchayathDto.setModifiedUser(1L);
			panchayathDto.setName(panchayath.getName());
			panchayathDto = panchayathDao.updte(panchayathDto);
			logger.info("Panchayath is updted");
		}
		return panchayathDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Panchayath getPanchayathById(Long id) {
		List<Panchayath> panchayathList = Optional.ofNullable(panchayathDao.findById(id))
				.orElseThrow(() -> new CustomException("Panchayath not found for this id :: " + id));
		return !panchayathList.isEmpty() ? panchayathList.get(0) : new Panchayath();

	}

	/**
	 * This method for get all state
	 * 
	 * @return
	 */
	public List<Panchayath> getAllPanchayath() {
		return panchayathDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(Panchayath::getId).reversed()).collect(Collectors.toList());
	}

}
