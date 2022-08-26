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
import com.village.survey.dao.SurveyResponseDao;
import com.village.survey.entity.SurveyResponse;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class SurveyResponseService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SurveyResponseDao surveyResponseDao;

	/**
	 * 
	 * @param SurveyResponse
	 * @return
	 */
	public SurveyResponse saveSurveyResponse(SurveyResponse surveyResponse) {
		// TODO user id need to be loaded form user context.
		surveyResponse.setCreatedUser(1L);
		surveyResponse.setModifiedUser(1L);
		return surveyResponseDao.save(surveyResponse);
	}

	/**
	 * This method for update SurveyResponse
	 * 
	 * @param state
	 * @return
	 */
	public SurveyResponse updateSurveyResponse(SurveyResponse surveyResponse) {
		List<SurveyResponse> surveyResponseList = Optional
				.ofNullable(surveyResponseDao.findById(surveyResponse.getId())).orElseThrow(
						() -> new CustomException("SurveyResponse not found for this id :: " + surveyResponse.getId()));
		SurveyResponse surveyResponseDto = new SurveyResponse();
		if (!surveyResponseList.isEmpty()) {
			surveyResponseDto = surveyResponseList.get(0);
			surveyResponseDto.setModifiedOn(new Date());
			surveyResponseDto.setModifiedUser(1L);
			surveyResponseDto = surveyResponseDao.updte(surveyResponseDto);
			logger.info("SurveyResponse is updted");
		}
		return surveyResponseDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public SurveyResponse getSurveyResponseById(Long id) {
		List<SurveyResponse> surveyResponseList = Optional.ofNullable(surveyResponseDao.findById(id))
				.orElseThrow(() -> new CustomException("SurveyResponse not found for this id :: " + id));
		return !surveyResponseList.isEmpty() ? surveyResponseList.get(0) : new SurveyResponse();

	}

	/**
	 * This method for get all SurveyResponse
	 * 
	 * @return
	 */
	public List<SurveyResponse> getAllSurveyResponse() {
		return surveyResponseDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(SurveyResponse::getId).reversed()).collect(Collectors.toList());
	}

}
