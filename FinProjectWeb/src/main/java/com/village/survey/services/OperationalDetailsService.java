package com.village.survey.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.core.util.CustomException;
import com.village.survey.dao.OperationalDetailsDao;
import com.village.survey.entity.OperationalDetails;

@Service
public class OperationalDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OperationalDetailsDao operationalDetailsDao;

	/**
	 * 
	 * @param OperationalDetails
	 * @return
	 */
	public OperationalDetails saveOperationalDetails(OperationalDetails operationalDetails) {
		// TODO user id need to be loaded form user context.
		return operationalDetailsDao.save(operationalDetails);
	}

	/**
	 * This method for update OperationalDetails
	 * 
	 * @param state
	 * @return
	 */
	public OperationalDetails updateOperationalDetails(OperationalDetails operationalDetails) {
		List<OperationalDetails> operationalDetailsList = Optional
				.ofNullable(operationalDetailsDao.findById(operationalDetails.getOperationalDetailsId()))
				.orElseThrow(() -> new CustomException(
						"OperationalDetails not found for this id :: " + operationalDetails.getOperationalDetailsId()));
		OperationalDetails operationalDetailsDto = new OperationalDetails();
		if (!operationalDetailsList.isEmpty()) {
			operationalDetailsDto = operationalDetailsList.get(0);
			operationalDetailsDto = operationalDetailsDao.updte(operationalDetailsDto);
			logger.info("OperationalDetails is updated");
		}
		return operationalDetailsDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public OperationalDetails getOperationalDetailsById(Long id) {
		List<OperationalDetails> operationalDetailsList = Optional.ofNullable(operationalDetailsDao.findById(id))
				.orElseThrow(() -> new CustomException("OperationalDetails not found for this id :: " + id));
		return !operationalDetailsList.isEmpty() ? operationalDetailsList.get(0) : new OperationalDetails();

	}

	/**
	 * This method for get all OperationalDetails
	 * 
	 * @return
	 */
	public List<OperationalDetails> getAllOperationalDetails() {
		return operationalDetailsDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(OperationalDetails::getOperationalDetailsId).reversed()).collect(Collectors.toList());
	}

}
