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

import com.village.survey.dto.MandalPincodeDTO;
import com.village.survey.entity.District;
import com.village.survey.rowmapper.DistrictDTORowMapper;
import com.village.survey.rowmapper.DistrictRowMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class DistrictDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("district").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param district
	 * @return
	 */
	public District save(District district) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(district);
		district.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to district table");
		return district;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<District> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("district_find_by_id"), parameters,
				new DistrictRowMapper());
	}

	/**
	 * 
	 * @param districtDto
	 * @return
	 */
	public District updte(District districtDto) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(districtDto);
		namedParameterJdbcTemplate.update(queries.get("district_update"), namedParameters);
		logger.info("updated to district table");
		return districtDto;
	}

	public List<District> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("district_find_all"), new DistrictRowMapper());
	}
	
	
	public List<District> findByState(List<Long> state) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		return namedParameterJdbcTemplate.query(queries.get("district_find_by_state"), parameters,
				new DistrictRowMapper());
	}

	public List<MandalPincodeDTO> findByDistrictId(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("district_details_by_id"), parameters,
				new DistrictDTORowMapper());
	}


}
