package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Address;

public class AdressRowMapper implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address=new Address();
		address.setId(rs.getLong("id"));
		address.setLang(rs.getString("lang"));
		address.setLat(rs.getString("lat"));
		return address;
	}
	

}
