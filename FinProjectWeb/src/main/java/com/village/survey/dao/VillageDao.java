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

import com.village.survey.dto.VillageDTO;
import com.village.survey.dto.VillageDistrictDTO;
import com.village.survey.entity.Village;
import com.village.survey.rowmapper.VillageDTORowMapper;
import com.village.survey.rowmapper.VillageDistrictDTORowMapper;
import com.village.survey.rowmapper.VillageRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class VillageDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("village").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param village
	 * @return
	 */
	public Village save(Village village) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(village);
		village.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to village table");
		return village;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Village> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("village_find_by_id"), parameters, new VillageRowMapper());
	}

	/**
	 * 
	 * @param village
	 * @return
	 */
	public Village updte(Village village) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(village);
		namedParameterJdbcTemplate.update(queries.get("village_update"), namedParameters);
		logger.info("updated to village table");
		return village;
	}

	public List<Village> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("village_find_all"), new VillageRowMapper());
	}

	public List<VillageDTO> findByBranchId(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("villageName_find_by_branch_id"), parameters, new VillageDTORowMapper());
	}
	
	public List<VillageDistrictDTO> findByVillageId(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("village_hierarchy_by_id"), parameters, new VillageDistrictDTORowMapper());
	}
	
	public List<Village> findByVillagesBlockId(Long id){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return findByVillagesBlockId(id);
	}
}
