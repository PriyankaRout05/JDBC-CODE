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

import com.village.survey.dto.MandalDTO;
import com.village.survey.entity.Mandal;
import com.village.survey.rowmapper.MandalDTORowMapper;
import com.village.survey.rowmapper.MandalRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class MandalDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("mandal").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param mandal
	 * @return
	 */
	public Mandal save(Mandal mandal) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(mandal);
		mandal.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to mandal table");
		return mandal;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Mandal> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("mandal_find_by_id"), parameters, new MandalRowMapper());
	}

	/**
	 * 
	 * @param mandal
	 * @return
	 */
	public Mandal updte(Mandal mandal) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(mandal);
		namedParameterJdbcTemplate.update(queries.get("mandal_update"), namedParameters);
		logger.info("updated to mandal table");
		return mandal;
	}

	public List<Mandal> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("mandal_find_all"), new MandalRowMapper());
	}

	public MandalDTO getAllDistrictByMandalId(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(queries.get("mandal_find_all_districts_state"), parameters,
				new MandalDTORowMapper());
	}

}
