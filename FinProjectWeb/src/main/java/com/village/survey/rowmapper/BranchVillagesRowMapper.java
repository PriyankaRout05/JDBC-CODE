package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.BranchVillages;

public class BranchVillagesRowMapper implements RowMapper<BranchVillages> {

	@Override
	public BranchVillages mapRow(ResultSet rs, int rowNum) throws SQLException {
		BranchVillages branchVillages = new BranchVillages();
		branchVillages.setId(rs.getLong("id"));
		branchVillages.setVillage(rs.getLong("village"));
		branchVillages.setBranch(rs.getLong("branch"));
		branchVillages.setCreatedOn(rs.getDate("created_on"));
		branchVillages.setCreatedUser(rs.getLong("created_user"));
		branchVillages.setModifiedOn(rs.getDate("modified_on"));
		branchVillages.setModifiedUser(rs.getLong("modified_user"));
		branchVillages.setActive(rs.getInt("active"));

		return branchVillages;
	}

}
