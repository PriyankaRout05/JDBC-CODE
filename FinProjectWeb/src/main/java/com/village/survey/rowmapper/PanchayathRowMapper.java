package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Panchayath;

/**
 * 
 * @author vamsir
 *
 */
public class PanchayathRowMapper implements RowMapper<Panchayath> {

	@Override
	public Panchayath mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Panchayath panchyath = new Panchayath();
		panchyath.setId(rs.getLong("id"));
		panchyath.setName(rs.getString("name"));
		panchyath.setMandal(rs.getLong("mandal"));
		panchyath.setCreatedOn(rs.getDate("created_on"));
		panchyath.setCreatedUser(rs.getLong("created_user"));
		panchyath.setModifiedOn(rs.getDate("modified_on"));
		panchyath.setModifiedUser(rs.getLong("modified_user"));
		panchyath.setActive(rs.getInt("active"));

		return panchyath;
	}
}
