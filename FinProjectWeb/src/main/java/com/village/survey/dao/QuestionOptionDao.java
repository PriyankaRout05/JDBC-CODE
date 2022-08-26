package com.village.survey.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.QuestionOption;
import com.village.survey.rowmapper.QuestionOptionRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class QuestionOptionDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired(required = false)
	private HashMap<String, String> queries;

	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void postConstruct() {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("question_option").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param questionOption
	 * @return
	 */
	public QuestionOption save(QuestionOption questionOption) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(questionOption);
		questionOption.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to QuestionOption table");
		return questionOption;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<QuestionOption> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("questionOption_find_by_id"), parameters,
				new QuestionOptionRowMapper());
	}

	/**
	 * 
	 * @param questionOption
	 * @return
	 */
	public QuestionOption updte(QuestionOption questionOption) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(questionOption);
		namedParameterJdbcTemplate.update(queries.get("questionOption_update"), namedParameters);
		logger.info("updated to QuestionOption table");
		return questionOption;
	}

	public List<QuestionOption> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("questionOption_find_all"), new QuestionOptionRowMapper());
	}

	public List<QuestionOption> getOptions(Long question) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("question", question);
		return namedParameterJdbcTemplate.query(queries.get("options_for_questions"), parameters,
				new QuestionOptionRowMapper());
	}
}
