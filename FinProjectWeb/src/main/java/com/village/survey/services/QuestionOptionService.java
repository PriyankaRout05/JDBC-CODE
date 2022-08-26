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
import com.village.survey.dao.QuestionOptionDao;
import com.village.survey.entity.QuestionOption;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class QuestionOptionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionOptionDao questionOptionDao;

	/**
	 * 
	 * @param questionOption
	 * @return
	 */
	public QuestionOption saveQuestionOption(QuestionOption questionOption) {
		// TODO user id need to be loaded form user context.
		questionOption.setCreatedUser(1L);
		questionOption.setModifiedUser(1L);
		return questionOptionDao.save(questionOption);
	}

	/**
	 * This method for update QuestionOption
	 * 
	 * @param state
	 * @return
	 */
	public QuestionOption updateQuestionOption(QuestionOption questionOption) {
		List<QuestionOption> questionOptionList = Optional
				.ofNullable(questionOptionDao.findById(questionOption.getId())).orElseThrow(
						() -> new CustomException("QuestionOption not found for this id :: " + questionOption.getId()));
		QuestionOption questionOptionDto = new QuestionOption();
		if (!questionOptionList.isEmpty()) {
			questionOptionDto = questionOptionList.get(0);
			questionOptionDto.setModifiedOn(new Date());
			questionOptionDto.setModifiedUser(1L);
			questionOptionDto.setOption(questionOption.getOption());
			questionOptionDto = questionOptionDao.updte(questionOptionDto);
			logger.info("QuestionOption is updted");
		}
		return questionOptionDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public QuestionOption getQuestionOptionById(Long id) {
		List<QuestionOption> questionOptionList = Optional.ofNullable(questionOptionDao.findById(id))
				.orElseThrow(() -> new CustomException("QuestionOption not found for this id :: " + id));
		return !questionOptionList.isEmpty() ? questionOptionList.get(0) : new QuestionOption();

	}

	/**
	 * This method for get all QuestionOption
	 * 
	 * @return
	 */
	public List<QuestionOption> getAllQuestionOption() {
		return questionOptionDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(QuestionOption::getId).reversed()).collect(Collectors.toList());
	}

}
