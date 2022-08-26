package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.SurveyQuestion;

/**
 * @author 
 *
 */
public class SurveyQuestionRowMapper implements RowMapper<SurveyQuestion> {

	@Override
	public SurveyQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
		SurveyQuestion surveyQuestion = new SurveyQuestion();
		surveyQuestion.setId(rs.getLong("id"));
		surveyQuestion.setQuestion(rs.getLong("question"));
		surveyQuestion.setSurvey(rs.getLong("survey"));
		surveyQuestion.setSectionNumber(rs.getInt("section_number"));
		surveyQuestion.setOrderNumber(rs.getInt("order_number"));
		surveyQuestion.setCreatedOn(rs.getTimestamp("created_on"));
		surveyQuestion.setCreatedUser(rs.getLong("created_user"));
		surveyQuestion.setModifiedUser(rs.getLong("modified_user"));
		surveyQuestion.setModifiedOn(rs.getTimestamp("modified_on"));
		surveyQuestion.setActive(rs.getInt("active"));
		return surveyQuestion;
	}

}
