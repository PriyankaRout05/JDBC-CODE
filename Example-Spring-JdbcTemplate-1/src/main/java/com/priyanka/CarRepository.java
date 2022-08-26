package com.priyanka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	@Autowired(required = false)
	private HashMap<String, String> queries;

	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void postconstruct() {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("car").withSchemaName("public")
				.usingGeneratedKeyColumns("quantity");
	}

	public List<Car> getAll() {
		return namedParameterJdbcTemplate.query(String.format(queries.get("findallcar")),
				new CarRowmapper());

	}

	public Car savecardata(Car car) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(car);
		car.setQuantity(simpleJdbcInsert.executeAndReturnKey(namedParameters).intValue());
		return car;
	}

	public Car update(Car car, int quantity) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(car);
		namedParameterJdbcTemplate.update(String.format(queries.get("upadate")), namedParameters);
		return car;

	}

	public List<Car> getbyquantity(int quantity) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("quantity", "quantity");
		return namedParameterJdbcTemplate.query(String.format(queries.get("findbycarquantity")), parameters,
				new CarRowmapper());
	}

}
