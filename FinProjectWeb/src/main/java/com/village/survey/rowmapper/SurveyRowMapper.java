package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Survey;

public class SurveyRowMapper implements RowMapper<Survey> {

	@Override
	public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {

		Survey survey = new Survey();
		survey.setId(rs.getLong("id"));
		survey.setName(rs.getString("name"));
		survey.setVillage(rs.getLong("village"));
		survey.setStatus(rs.getString("status"));
		survey.setCreatedOn(rs.getDate("created_on"));
		survey.setCreatedUser(rs.getLong("created_user"));
		survey.setModifiedOn(rs.getDate("modified_on"));
		survey.setModifiedUser(rs.getLong("modified_user"));
		survey.setActive(rs.getInt("active"));

		return survey;

	}

}
