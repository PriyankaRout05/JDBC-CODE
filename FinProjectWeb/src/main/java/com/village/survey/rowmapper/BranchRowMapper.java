package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.Branch;

/**
 * 
 * @author vamsir
 *
 */
public class BranchRowMapper implements RowMapper<Branch> {

	@Override
	public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

		Branch branch = new Branch();
		branch.setId(rs.getLong("id"));
		branch.setName(rs.getString("name"));
		branch.setMandal(rs.getLong("mandal"));
		branch.setCreatedOn(rs.getDate("created_on"));
		branch.setCreatedUser(rs.getLong("created_user"));
		branch.setModifiedOn(rs.getDate("modified_on"));
		branch.setModifiedUser(rs.getLong("modified_user"));
		branch.setActive(rs.getInt("active"));

		return branch;
	}
}
