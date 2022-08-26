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

import com.village.survey.entity.BranchVillages;
import com.village.survey.rowmapper.BranchVillagesRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class BranchVillagesDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("branch_villages").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param branchVillages
	 * @return
	 */
	public BranchVillages save(BranchVillages branchVillages) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branchVillages);
		branchVillages.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to BranchVillages table");
		return branchVillages;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<BranchVillages> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("branchVillages_find_by_id"), parameters,
				new BranchVillagesRowMapper());
	}

	/**
	 * 
	 * @param branchVillages
	 * @return
	 */
	public BranchVillages updte(BranchVillages branchVillages) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branchVillages);
		namedParameterJdbcTemplate.update(queries.get("branchVillages_update"), namedParameters);
		logger.info("updated to BranchVillages table");
		return branchVillages;
	}

	public List<BranchVillages> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("branchVillages_find_all"), new BranchVillagesRowMapper());
	}

}
