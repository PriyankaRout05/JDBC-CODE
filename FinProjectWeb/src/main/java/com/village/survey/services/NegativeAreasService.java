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
import com.village.survey.dao.NegativeAreasDao;
import com.village.survey.entity.NegativeAreas;
@Service
public class NegativeAreasService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NegativeAreasDao negativeAreasDao;

	/**
	 * 
	 * @param negativeareas
	 * @return
	 */
	public NegativeAreas saveNegativeAreas(NegativeAreas negativeAreas) {
//		 TODO user id need to be loaded form user context.
		negativeAreas.setCreatedUser(1L);
		negativeAreas.setModifiedUser(1L);
		return negativeAreasDao.save(negativeAreas);
	}

	
	public NegativeAreas updateNegativeAreas(NegativeAreas negativeAreas) {
		List<NegativeAreas> negativeareasList = Optional.ofNullable(negativeAreasDao.findById(negativeAreas.getId()))
				.orElseThrow(() -> new CustomException("NegativeAreas not found for this id :: " + negativeAreas.getId()));
		NegativeAreas negativeAreasDto = new NegativeAreas();
		if (!negativeareasList.isEmpty()) {
			negativeAreasDto =  negativeareasList.get(0);
			negativeAreasDto.setModifiedOn(new Date());
			negativeAreasDto.setModifiedUser(1L);
			negativeAreasDto.setName(negativeAreas.getName());
			negativeAreasDto =negativeAreasDao.updte(negativeAreasDto);
			logger.info("NegativeAreas is updated");
		}
		return negativeAreasDto;
	}

	
	public NegativeAreas getNegativeAreasById(Long id) {
		List<NegativeAreas> negativeAreasList = Optional.ofNullable(negativeAreasDao.findById(id))
				.orElseThrow(() -> new CustomException("NegativeAreas not found for this id :: " + id));
		return !negativeAreasList.isEmpty() ? negativeAreasList.get(0) : new NegativeAreas();

	}

	/**
	 * This method for get all NegativeAreas
	 * 
	 * @return
	 */
	public List<NegativeAreas> getAllNegativeAreas() {
		return negativeAreasDao.findAll().stream().parallel().sorted(Comparator.comparingLong(NegativeAreas::getId).reversed())
				.collect(Collectors.toList());
	}

	


}
