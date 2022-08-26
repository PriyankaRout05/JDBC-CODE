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

import com.village.survey.entity.VillagePhotos;
import com.village.survey.rowmapper.VillagePhotosRowMapper;

/**
 * @author
 *
 */
@Repository
public class VillagePhotosDao {

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
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("village_photos").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	/**
	 * 
	 * @param VillagePhotos
	 * @return
	 */
	public VillagePhotos save(VillagePhotos villagePhotos) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(villagePhotos);
		villagePhotos.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
		logger.info("record inserted to VillagePhotos table");
		return villagePhotos;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<VillagePhotos> findById(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.query(queries.get("villagePhotos_find_by_id"), parameters,
				new VillagePhotosRowMapper());
	}

	/**
	 * 
	 * @param VillagePhotos
	 * @return
	 */
	public VillagePhotos update(VillagePhotos villagePhotos) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(villagePhotos);
		namedParameterJdbcTemplate.update(queries.get("villagePhotos_update"), namedParameters);
		logger.info("updated to VillagePhotos table");
		return villagePhotos;
	}

	public List<VillagePhotos> findAll() {
		return namedParameterJdbcTemplate.query(queries.get("villagePhotos_find_all"), new VillagePhotosRowMapper());
	}

}
