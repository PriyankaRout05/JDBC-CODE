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

import com.village.survey.entity.SurveyResponse;
import com.village.survey.rowmapper.SurveyResponseRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class SurveyResponseDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("survey_response").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param surveyResponse
	 * @return
	 */
	public SurveyResponse save(SurveyResponse surveyResponse) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(surveyResponse);
		surveyResponse.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to SurveyResponse table");
		return surveyResponse;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<SurveyResponse> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("surveyResponse_find_by_id"), parameters,
				new SurveyResponseRowMapper());
	}

	/**
	 * 
	 * @param surveyResponse
	 * @return
	 */
	public SurveyResponse updte(SurveyResponse surveyResponse) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(surveyResponse);
		namedParameterJdbcTemplate.update(queries.get("surveyResponse_update"), namedParameters);
		logger.info("updated to SurveyResponse table");
		return surveyResponse;
	}

	public List<SurveyResponse> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("surveyResponse_find_all"), new SurveyResponseRowMapper());
	}

}
