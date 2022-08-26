package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.VillageClassification;

/**
 * 
 * @author vamsir
 *
 */
public class VillageClassificationRowMapper implements RowMapper<VillageClassification> {

	@Override
	public VillageClassification mapRow(ResultSet rs, int rowNum) throws SQLException {

		VillageClassification classification = new VillageClassification();
		classification.setId(rs.getLong("id"));
		classification.setName(rs.getString("name"));
		classification.setCreatedOn(rs.getDate("created_on"));
		classification.setCreatedUser(rs.getLong("created_user"));
		classification.setModifiedOn(rs.getDate("modified_on"));
		classification.setModifiedUser(rs.getLong("modified_user"));
		classification.setActive(rs.getInt("active"));

		return classification;
	}
}
