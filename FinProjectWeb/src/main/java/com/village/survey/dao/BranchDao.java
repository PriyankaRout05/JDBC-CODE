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

import com.village.survey.dto.BranchDTO;
import com.village.survey.entity.Branch;
import com.village.survey.rowmapper.BranchDTORowMapper;
import com.village.survey.rowmapper.BranchRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class BranchDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("branch").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param branch
	 * @return
	 */
	public Branch save(Branch branch) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branch);
		branch.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to Branch table");
		return branch;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Branch> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("branch_find_by_id"), parameters, new BranchRowMapper());
	}

	/**
	 * updating branch
	 * @param branch
	 * @return branch
	 */
	public Branch updte(Branch branch) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branch);
		namedParameterJdbcTemplate.update(queries.get("branch_update"), namedParameters);
		logger.info("updated to branch table");
		return branch;
	}

	public List<Branch> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("branch_find_all"), new BranchRowMapper());
	}

	public BranchDTO getAllDistrictByBranchId(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(queries.get("branch_find_all_districts_branch"), parameters,
				new BranchDTORowMapper());
	}

	public List<Branch> findByname(String name) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		
		String query = queries.get("branch_find_by_name");
		query = query + "'" + name + "%'";
		return namedParameterJdbcTemplate.query(query, parameters, new BranchRowMapper());
	}

}
