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
import com.village.survey.entity.BranchOperationalBlocks;
import com.village.survey.rowmapper.BranchDTORowMapper;
import com.village.survey.rowmapper.BranchOperationalBlocksRowMapper;

@Repository
public class BranchOperationalBlocksDao {
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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("branch_operational_blocks")
				.withSchemaName("public").usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param branch
	 * @return
	 */
	public BranchOperationalBlocks save(BranchOperationalBlocks branch) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branch);
		branch.setId(simpleJdbcInsert.executeAndReturnKey(namedParameters).longValue());
		logger.info("record inserted to Branch_operational_blocks table");
		return branch;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<BranchOperationalBlocks> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		logger.info("fetched single branch_operational_blocks record successfully");
		return namedParameterJdbcTemplate.query(queries.get("branch_operational_blocks_find_by_id"), parameters,
				new BranchOperationalBlocksRowMapper());
	}

	/**
	 * 
	 * @param branch
	 * @return
	 */
	public BranchOperationalBlocks update(BranchOperationalBlocks branch) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(branch);
		namedParameterJdbcTemplate.update(queries.get("branch_operational_blocks_update"), namedParameters);
		logger.info("updated to branch_operational_blocks table");
		return branch;
	}

	public List<BranchOperationalBlocks> findAll() {
		logger.info("fetched all data from branch_operational_blocks table");
		return namedParameterJdbcTemplate.query(queries.get("branch_operational_blocks_find_all"),
				new BranchOperationalBlocksRowMapper());
	}

	public BranchDTO getAllBranchOperationalBlocksById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(queries.get("branch_operational_blocks_details"), parameters,
		new BranchDTORowMapper());
		}
}
