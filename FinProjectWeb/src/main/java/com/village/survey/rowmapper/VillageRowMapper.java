package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Village;

/**
 * 
 * @author vamsir
 *
 */
public class VillageRowMapper implements RowMapper<Village> {

	@Override
	public Village mapRow(ResultSet rs, int rowNum) throws SQLException {

		Village village = new Village();
		village.setId(rs.getLong("id"));
		village.setName(rs.getString("name"));
		village.setPanchayath(rs.getLong("panchayath"));
		village.setClassification(rs.getLong("classification"));
		village.setNoOfHouseholds(rs.getLong("no_of_households"));
		village.setRoute(rs.getString("route"));
		village.setPincode(rs.getInt("pincode"));
		village.setCreatedOn(rs.getDate("created_on"));
		village.setCreatedUser(rs.getLong("created_user"));
		village.setModifiedOn(rs.getDate("modified_on"));
		village.setModifiedUser(rs.getLong("modified_user"));
		village.setActive(rs.getInt("active"));

		return village;
	}
}
