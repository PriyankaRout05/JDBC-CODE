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

import com.village.survey.entity.FinancialInstitutions;
import com.village.survey.rowmapper.FinancialInstitutionsRowMapper;

/**
 * @author
 *
 */
@Repository
public class FinancialInstitutionsDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("financial_institutions")
				.withSchemaName("public").usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param FinancialInstitutions
	 * @return
	 */
	public FinancialInstitutions save(FinancialInstitutions financialInstitutions) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(financialInstitutions);
		financialInstitutions.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to FinancialInstitutions table");
		return financialInstitutions;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<FinancialInstitutions> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("financialInstitutions_find_by_id"), parameters,
				new FinancialInstitutionsRowMapper());
	}

	/**
	 * 
	 * @param FinancialInstitutions
	 * @return
	 */
	public FinancialInstitutions updte(FinancialInstitutions financialInstitutions) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(financialInstitutions);
		namedParameterJdbcTemplate.update(queries.get("financialInstitutions_update"), namedParameters);
		logger.info("updated to FinancialInstitutions table");
		return financialInstitutions;
	}

	public List<FinancialInstitutions> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("financialInstitutions_find_all"),
				new FinancialInstitutionsRowMapper());
	}

}
