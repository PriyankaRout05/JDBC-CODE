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
import com.village.survey.dao.SurveyDao;
import com.village.survey.entity.Survey;

@Service
public class SurveyService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SurveyDao surveyDao;

	public Survey saveSurvey(Survey survey) {
		// TODO user id need to be loaded form user context.
		survey.setCreatedUser(1L);
		survey.setModifiedUser(1L);
		return surveyDao.save(survey);
	}

	/**
	 * This method for update Survey
	 *
	 * @param state
	 * @return
	 */
	public Survey updateSurvey(Survey survey) {
		List<Survey> surveyList = Optional.ofNullable(surveyDao.findById(survey.getId()))
				.orElseThrow(() -> new CustomException("Survey not found for this id :: " + survey.getId()));
		Survey surveyDto = new Survey();
		if (!surveyList.isEmpty()) {
			surveyDto = surveyList.get(0);
			surveyDto.setModifiedOn(new Date());
			surveyDto.setModifiedUser(1L);
			surveyDto.setVillage(survey.getVillage());
			surveyDto.setStatus(survey.getStatus());
			surveyDto.setName(survey.getName());
			surveyDto = surveyDao.update(surveyDto);
			logger.info("Survey is updated");
		}
		return surveyDto;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public Survey getSurveyById(Long id) {
		List<Survey> surveyList = Optional.ofNullable(surveyDao.findById(id))
				.orElseThrow(() -> new CustomException("Survey not found for this id :: " + id));
		return !surveyList.isEmpty() ? surveyList.get(0) : new Survey();

	}

	/**
	 * This method for get all Survey
	 *
	 * @return
	 */
	public List<Survey> getAllSurvey() {
		return surveyDao.findAll().stream().parallel().sorted(Comparator.comparingLong(Survey::getId).reversed())
				.collect(Collectors.toList());
	}
}
