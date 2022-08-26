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

import com.village.survey.entity.OperationalDetails;
import com.village.survey.rowmapper.OperationalDetailsRowMapper;

@Repository
public class OperationalDetailsDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("operational_details")
				.withSchemaName("public").usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param OperationalDetails
	 * @return
	 */
	public OperationalDetails save(OperationalDetails operationalDetails) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(operationalDetails);
		operationalDetails.setOperationalDetailsId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to OperationalDetails table");
		return operationalDetails;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<OperationalDetails> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("operationalDetails_find_by_id"), parameters,
				new OperationalDetailsRowMapper());
	}

	/**
	 * 
	 * @param OperationalDetails
	 * @return
	 */
	public OperationalDetails updte(OperationalDetails operationalDetails) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(operationalDetails);
		namedParameterJdbcTemplate.update(queries.get("operationalDetails_update"), namedParameters);
		logger.info("updated to OperationalDetails table");
		return operationalDetails;
	}

	public List<OperationalDetails> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("operationalDetails_find_all"),
				new OperationalDetailsRowMapper());
	}

}
