package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Question;

/**
 * @author 
 *
 */
public class QuestionRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {

		Question question = new Question();
		question.setId(rs.getLong("id"));
		question.setQuestion(rs.getString("question"));
		question.setType(rs.getString("type"));
		question.setCreatedOn(rs.getTimestamp("created_on"));
		question.setCreatedUser(rs.getLong("created_user"));
		question.setModifiedUser(rs.getLong("modified_user"));
		question.setModifiedOn(rs.getTimestamp("modified_on"));
		question.setActive(rs.getInt("active"));
		return question;
	}

}
