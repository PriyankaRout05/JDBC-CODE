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
import com.village.survey.dao.FinancialInstitutionsDao;
import com.village.survey.entity.FinancialInstitutions;

/**
 * @author
 *
 */
@Service
public class FinancialInstitutionsService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FinancialInstitutionsDao financialInstitutionsDao;

	/**
	 * 
	 * @param financialInstitutions
	 * @return
	 */
	public FinancialInstitutions saveFinancialInstitutions(FinancialInstitutions financialInstitutions) {
		// TODO user id need to be loaded form user context.
		financialInstitutions.setCreatedUser(1L);
		financialInstitutions.setModifiedUser(1L);
		return financialInstitutionsDao.save(financialInstitutions);
	}

	/**
	 * This method for update financialInstitutions
	 * 
	 * @param state
	 * @return
	 */
	public FinancialInstitutions updateFinancialInstitutions(FinancialInstitutions financialInstitutions) {
		List<FinancialInstitutions> financialInstitutionsList = Optional
				.ofNullable(financialInstitutionsDao.findById(financialInstitutions.getId()))
				.orElseThrow(() -> new CustomException(
						"financialInstitutions not found for this id :: " + financialInstitutions.getId()));
		FinancialInstitutions financialInstitutionsDto = new FinancialInstitutions();
		if (!financialInstitutionsList.isEmpty()) {
			financialInstitutionsDto = financialInstitutionsList.get(0);
			financialInstitutionsDto.setModifiedOn(new Date());
			financialInstitutionsDto.setModifiedUser(1L);
			financialInstitutionsDto.setName(financialInstitutions.getName());
			financialInstitutionsDto = financialInstitutionsDao.updte(financialInstitutionsDto);
			logger.info("financialInstitutions is updted");
		}
		return financialInstitutionsDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public FinancialInstitutions getFinancialInstitutionsById(Long id) {
		List<FinancialInstitutions> financialInstitutionsList = Optional
				.ofNullable(financialInstitutionsDao.findById(id))
				.orElseThrow(() -> new CustomException("financialInstitutions not found for this id :: " + id));
		return !financialInstitutionsList.isEmpty() ? financialInstitutionsList.get(0) : new FinancialInstitutions();

	}

	/**
	 * This method for get all financialInstitutions
	 * 
	 * @return
	 */
	public List<FinancialInstitutions> getAllFinancialInstitutions() {
		return financialInstitutionsDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(FinancialInstitutions::getId).reversed()).collect(Collectors.toList());
	}

}
