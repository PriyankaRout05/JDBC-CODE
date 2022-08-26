package com.village.survey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.dao.QuestionDao;
import com.village.survey.entity.Question;

/**
 * @author
 *
 */
@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	/**
	 * Method to get all questions
	 * 
	 * @return all questions
	 */
	public List<Question> getAllQuestion() {
		return questionDao.findAll();
	}

	/**
	 * Method to save question
	 * 
	 * @param question
	 */
	public void saveQuestion(Question question) {
		question.setCreatedUser(1L);
		question.setModifiedUser(1L);
		questionDao.save(question);
	}

	/**
	 * Method to get question by passing id
	 * 
	 * @param id
	 * @return question
	 */
	public Question getQuestionById(Long id) {
		return questionDao.findById(id);
	}

	/**
	 * Method to update question
	 * 
	 * @param question,id
	 * @return updated question
	 */

	public Question updateQuestion(Question question, long id) {
		Question questionUpdate = questionDao.findById(id);
		questionUpdate.setQuestion(question.getQuestion());
		return questionDao.update(questionUpdate);
	}
}
