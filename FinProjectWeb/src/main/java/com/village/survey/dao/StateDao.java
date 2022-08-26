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

import com.village.survey.entity.State;
import com.village.survey.rowmapper.StateRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class StateDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("state").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param state
	 * @return
	 */
	public State save(State state) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(state);
		state.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to state table");
		return state;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<State> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("state_find_by_id"), parameters,
				new StateRowMapper());
	}

	/**
	 * 
	 * @param stateDto
	 * @return
	 */
	public State updte(State stateDto) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(stateDto);
		namedParameterJdbcTemplate.update(queries.get("state_update"), namedParameters);
		logger.info("updated to state table");
		return stateDto;
	}

	public List<State> findAll() {
		return namedParameterJdbcTemplate.query(String.format(queries.get("state_find_all")), new StateRowMapper());
	}

}
