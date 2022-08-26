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

import com.village.survey.entity.NegativeAreas;
import com.village.survey.rowmapper.NegativeAreasRowMapper;
@Repository
public class NegativeAreasDao {
	
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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("negative_areas").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param negativeareas
	 * @return
	 */
	public NegativeAreas save(NegativeAreas negativeAreas) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(negativeAreas);
		negativeAreas.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to NegativeAreas table");
		return negativeAreas;
	}


	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<NegativeAreas> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("negativeareas_find_by_id"), parameters, new NegativeAreasRowMapper());
	}

	/**
	 * updating negativeareas
	 * @param negativeareas
	 * @return negativeareas
	 */
	public NegativeAreas updte(NegativeAreas negativeAreas) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(negativeAreas);
		namedParameterJdbcTemplate.update(queries.get("negativeareas_update"), namedParameters);
		logger.info("updated to negativeareas table");
		return negativeAreas;
	}

	public List<NegativeAreas> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("negativeareas_find_all"), new NegativeAreasRowMapper());
	}


}
