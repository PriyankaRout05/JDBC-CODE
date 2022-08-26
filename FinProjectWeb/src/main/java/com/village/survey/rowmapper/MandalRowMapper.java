package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Mandal;

/**
 * 
 * @author vamsir
 *
 */
public class MandalRowMapper implements RowMapper<Mandal> {

	@Override
	public Mandal mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Mandal mandal = new Mandal();
		mandal.setId(rs.getLong("id"));
		mandal.setName(rs.getString("name"));
		mandal.setDistrict(rs.getLong("district"));
		mandal.setCreatedOn(rs.getDate("created_on"));
		mandal.setCreatedUser(rs.getLong("created_user"));
		mandal.setModifiedOn(rs.getDate("modified_on"));
		mandal.setModifiedUser(rs.getLong("modified_user"));
		mandal.setActive(rs.getInt("active"));

		return mandal;
	}
}
