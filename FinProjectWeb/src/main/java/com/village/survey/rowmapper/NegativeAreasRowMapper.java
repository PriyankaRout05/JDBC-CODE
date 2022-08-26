package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.NegativeAreas;

public class NegativeAreasRowMapper implements RowMapper<NegativeAreas> {

	@Override
	public NegativeAreas mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NegativeAreas negativeareas = new NegativeAreas();
		negativeareas.setId(rs.getLong("id"));
		negativeareas.setBranchId(rs.getLong("branch_id"));
		negativeareas.setName(rs.getString("name"));
		negativeareas.setCreatedOn(rs.getDate("created_on"));
		negativeareas.setCreatedUser(rs.getLong("created_user"));
		negativeareas.setModifiedOn(rs.getDate("modified_on"));
		negativeareas.setModifiedUser(rs.getLong("modified_user"));
		
		return negativeareas;
	}

}
