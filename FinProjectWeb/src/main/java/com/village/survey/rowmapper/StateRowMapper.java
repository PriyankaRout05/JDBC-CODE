package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.State;

/**
 * 
 * @author vamsir
 *
 */
public class StateRowMapper implements RowMapper<State> {

	@Override
	public State mapRow(ResultSet rs, int rowNum) throws SQLException {

		State state = new State();

		state.setId(rs.getLong("id"));
		state.setName(rs.getString("name"));
		state.setCreatedOn(rs.getDate("created_on"));
		state.setCreatedUser(rs.getLong("created_user"));
		state.setModifiedOn(rs.getDate("modified_on"));
		state.setModifiedUser(rs.getLong("modified_user"));
		state.setActive(rs.getInt("active"));

		return state;
	}
}
