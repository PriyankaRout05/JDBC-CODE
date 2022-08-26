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

import com.village.survey.entity.Survey;
import com.village.survey.rowmapper.SurveyRowMapper;

@Repository
public class SurveyDao {
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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("survey").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	public Survey save(Survey survey) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(survey);
		survey.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to Survey table");
		return survey;
	}

	public List<Survey> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("survey_find_by_id"), parameters, new SurveyRowMapper());
	}

	/**
	 *
	 * @param branch
	 * @return
	 */
	public Survey update(Survey survey) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(survey);
		namedParameterJdbcTemplate.update(queries.get("survey_update"), namedParameters);
		logger.info("updated to Survey table");
		return survey;
	}

	public List<Survey> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("survey_find_all"), new SurveyRowMapper());
	}
}
