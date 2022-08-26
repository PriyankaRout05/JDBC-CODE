package com.priyanka;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CarRowmapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.setQuantity(rs.getInt("quantity"));
		car.setCompany(rs.getString("column"));
		car.setModel(rs.getString("model"));
		car.setLocality(rs.getString("locality"));
		
		return car;
	}

}
