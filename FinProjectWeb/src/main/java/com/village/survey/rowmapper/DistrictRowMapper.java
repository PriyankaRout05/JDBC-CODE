package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.District;

/**
 * 
 * @author vamsir
 *
 */
public class DistrictRowMapper implements RowMapper<District> {

	@Override
	public District mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		District district = new District();
		district.setId(rs.getLong("id"));
		district.setName(rs.getString("name"));
		district.setState(rs.getLong("state"));
		district.setCreatedOn(rs.getDate("created_on"));
		district.setCreatedUser(rs.getLong("created_user"));
		district.setModifiedOn(rs.getDate("modified_on"));
		district.setModifiedUser(rs.getLong("modified_user"));
		district.setActive(rs.getInt("active"));

		return district;
	}
}
