package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.SurveyResponse;

/**
 * 
 * @author vamsir
 *
 */
public class SurveyResponseRowMapper implements RowMapper<SurveyResponse> {

	@Override
	public SurveyResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

		SurveyResponse response = new SurveyResponse();
		response.setId(rs.getLong("id"));
		response.setSurveyQuestion(rs.getLong("survey_question"));
		response.setOption(rs.getLong("option"));
		response.setCreatedOn(rs.getDate("created_on"));
		response.setCreatedUser(rs.getLong("created_user"));
		response.setModifiedOn(rs.getDate("modified_on"));
		response.setModifiedUser(rs.getLong("modified_user"));
		response.setActive(rs.getInt("active"));

		return response;
	}
}
