package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Activity;

public class ActivityRowMapper implements RowMapper<Activity> {

	@Override
	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {

		Activity activity = new Activity();

		activity.setId(rs.getLong("id"));
		activity.setName(rs.getString("name"));
		activity.setCreatedOn(rs.getDate("created_on"));
		activity.setCreatedUser(rs.getLong("created_user"));
		activity.setModifiedOn(rs.getDate("modified_on"));
		activity.setModifiedUser(rs.getLong("modified_user"));
		activity.setActive(rs.getInt("active"));

		return activity;
	}

}
