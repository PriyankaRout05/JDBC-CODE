package com.village.survey.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.SurveyQuestion;
import com.village.survey.rowmapper.SurveyQuestionRowMapper;

/**
 * @author 
 *
 */
@Repository
public class SurveyQuestionDao {
	@Autowired(required = false)
	private HashMap<String, String> queries;

	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void postConstruct() {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("survey_question").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * Method to save surveyQuestion
	 * @param surveyQuestion
	 * @return surveyQuestion
	 */
	public SurveyQuestion save(SurveyQuestion surveyQuestion) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(surveyQuestion);
		surveyQuestion.setId((Long) simpleJdbcInsert.executeAndReturnKey(sqlParameterSource));
		return surveyQuestion;
	}

	/**
	 * Method to update surveyQuestion
	 * @param surveyQuestion
	 * @return updated surveyQuestion
	 */
	public SurveyQuestion update(SurveyQuestion surveyQuestion) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(surveyQuestion);
		namedParameterJdbcTemplate.update(String.format(queries.get("surveyQuestion_update")), sqlParameterSource);
		return surveyQuestion;
	}

	/**
	 * Method to get all surveyQuestions
	 * @returns all questions
	 */
	public List<SurveyQuestion> findAll() {

		return namedParameterJdbcTemplate.query(String.format(queries.get("surveyQuestion_find_all")),
				new SurveyQuestionRowMapper());
	}

	/**
	 * Method to get surveyQuestion by passing id
	 * @param id
	 * @return surveyQuestion
	 */
	public SurveyQuestion findById(Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);

		return namedParameterJdbcTemplate.queryForObject(queries.get("surveyQuestion_find_by_id"), map,
				new SurveyQuestionRowMapper());
	}
}
