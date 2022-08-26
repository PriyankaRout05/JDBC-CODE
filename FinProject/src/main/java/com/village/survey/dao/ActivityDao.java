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

import com.village.survey.entity.Activity;
import com.village.survey.rowmapper.ActivityRowMapper;


@Repository
public class ActivityDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired(required = false)
	private HashMap<String, String> queries;

	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private DataSource dataSource;

	/**
	 * 
	 */
	@PostConstruct
	private void postConstruct() {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("activity").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}
	
	
	/**
	 * @param activity
	 * @return
	 */
	public Activity save(Activity activity) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(activity);
		activity.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to activity table");
		return activity;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Activity> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("activity_find_by_id"), parameters,
				new ActivityRowMapper());
	}

	/**
	 * @param activityDto
	 * @return
	 */
	public Activity updte(Activity activityDto) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(activityDto);
		namedParameterJdbcTemplate.update(queries.get("activity_update"), namedParameters);
		logger.info("updated to activity table");
		return activityDto;
	}

	/**
	 * @return
	 */
	public List<Activity> findAll() {
		return namedParameterJdbcTemplate.query(String.format(queries.get("activity_find_all")),
				new ActivityRowMapper());
	}

	


}
