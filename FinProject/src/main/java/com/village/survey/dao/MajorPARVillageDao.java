package com.village.survey.dao;
//package com.village.survey.dao;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import com.village.survey.entity.MajorPARVillage;
//import com.village.survey.rowmapper.MajorPARVillageRowMapper;
//
//public class MajorPARVillageDao {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired(required = false)
//	private HashMap<String, String> queries;
//
//	private SimpleJdbcInsert simpleJdbcInsert;
//
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@PostConstruct
//	private void postConstruct() {
//		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("majorPARVillage").withSchemaName("public")
//				.usingGeneratedKeyColumns("id");
//	}
//
//	/**
//	 * @param majorPARVillage
//	 * @return
//	 */
//	public MajorPARVillage save(MajorPARVillage majorPARVillage) {
//		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(majorPARVillage);
//		majorPARVillage.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
//		logger.info("record inserted to MajorPARVillage table");
//		return majorPARVillage;
//	}
//
//	/**
//	 * @return
//	 */
//	public List<MajorPARVillage> findAll() {
//		return namedParameterJdbcTemplate.query(queries.get("majorPARVillage_find_all"),
//				new MajorPARVillageRowMapper());
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	public List<MajorPARVillage> findById(Long id) {
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("id", id);
//		return namedParameterJdbcTemplate.query(queries.get("majorPARVillage_find_by_id"), parameters,
//				new MajorPARVillageRowMapper());
//	}
//
//	/**
//	 * @param majorPARVillage
//	 * @return
//	 */
//	public MajorPARVillage updte(MajorPARVillage majorPARVillage) {
//		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(majorPARVillage);
//		namedParameterJdbcTemplate.update(queries.get("majorPARVillage_update"), namedParameters);
//		logger.info("updated to majorPARVillage table");
//		return majorPARVillage;
//	}
//
//}
