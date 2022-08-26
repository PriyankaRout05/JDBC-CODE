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

import com.village.survey.entity.Question;
import com.village.survey.rowmapper.QuestionRowMapper;

/**
 * @author 
 *
 */
@Repository
public class QuestionDao {
	@Autowired(required = false)
	private HashMap<String, String> queries;

	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void postConstruct() {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("question").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * Method to save question
	 * @param question
	 * @return question
	 */
	public Question save(Question question) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(question);
		question.setId((Long) simpleJdbcInsert.executeAndReturnKey(sqlParameterSource));
		return question;
	}

	/**
	 * Method to update question
	 * @param question
	 * @return updated question
	 */
	public Question update(Question question) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(question);
		namedParameterJdbcTemplate.update(String.format(queries.get("question_update")), sqlParameterSource);
		return question;
	}

	/**
	 * Method to get all questions
	 * @returns all questions
	 */
	public List<Question> findAll() {

		return namedParameterJdbcTemplate.query(String.format(queries.get("question_find_all")), new QuestionRowMapper());
	}

	/**
	 * Method to get question by passing id
	 * @param id
	 * @return question
	 */
	public Question findById(Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);

		return namedParameterJdbcTemplate.queryForObject(queries.get("question_find_by_id"), map, new QuestionRowMapper());
	}
}
