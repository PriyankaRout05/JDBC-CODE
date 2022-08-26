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

import com.village.survey.entity.Panchayath;
import com.village.survey.rowmapper.PanchayathRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class PanchayathDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("panchayath").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param panchayath
	 * @return
	 */
	public Panchayath save(Panchayath panchayath) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(panchayath);
		panchayath.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to panchayath table");
		return panchayath;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Panchayath> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("panchayath_find_by_id"), parameters,
				new PanchayathRowMapper());
	}

	/**
	 * 
	 * @param panchayath
	 * @return
	 */
	public Panchayath updte(Panchayath panchayath) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(panchayath);
		namedParameterJdbcTemplate.update(queries.get("panchayath_update"), namedParameters);
		logger.info("updated to panchayath table");
		return panchayath;
	}

	public List<Panchayath> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("panchayath_find_all"), new PanchayathRowMapper());
	}

}
