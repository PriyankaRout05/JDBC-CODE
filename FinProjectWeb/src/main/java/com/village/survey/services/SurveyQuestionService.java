package com.village.survey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.dao.SurveyQuestionDao;
import com.village.survey.entity.SurveyQuestion;

/**
 * @author
 *
 */
@Service
public class SurveyQuestionService {
	@Autowired
	SurveyQuestionDao surveyQuestionDao;

	/**
	 * Method to get all surveyQuestions
	 * 
	 * @returns all surveyQuestions
	 */
	public List<SurveyQuestion> getAllSurveyQuestion() {
		return surveyQuestionDao.findAll();
	}

	/**
	 * Method to save surveyQuestion
	 * 
	 * @param surveyQuestion
	 */
	public void saveSurveyQuestion(SurveyQuestion surveyQuestion) {
		surveyQuestion.setCreatedUser(1L);
		surveyQuestion.setModifiedUser(1L);
		surveyQuestionDao.save(surveyQuestion);
	}

	/**
	 * Method to get surveyQuestion by passing id
	 * 
	 * @param id
	 * @return surveyQuestion
	 */
	public SurveyQuestion getSurveyQuestionById(Long id) {
		return surveyQuestionDao.findById(id);
	}

	/**
	 * Method to update surveyQuestion
	 * 
	 * @param surveyQuestion,id
	 * @return updated surveyQuestion
	 */
	public SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion, Long id) {

		SurveyQuestion surveyQuestionUpdate = surveyQuestionDao.findById(id);
		surveyQuestionUpdate.setSectionNumber(surveyQuestion.getSectionNumber());
		return surveyQuestionDao.update(surveyQuestionUpdate);
	}
}
