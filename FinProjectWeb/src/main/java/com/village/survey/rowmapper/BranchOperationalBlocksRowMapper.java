package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.BranchOperationalBlocks;

public class BranchOperationalBlocksRowMapper implements RowMapper<BranchOperationalBlocks> {

	@Override
	public BranchOperationalBlocks mapRow(ResultSet rs, int rowNum) throws SQLException {
		BranchOperationalBlocks blocks= new BranchOperationalBlocks();
		blocks.setId(rs.getLong("id"));
		blocks.setBranchId(rs.getLong("branch_id"));
		blocks.setBlockId(rs.getLong("block_id"));
		blocks.setCreatedOn(rs.getDate("created_on"));
		blocks.setCreatedUser(rs.getLong("created_user"));
		blocks.setModifiedOn(rs.getDate("modified_on"));
		blocks.setModifiedUser(rs.getLong("modified_user"));
		blocks.setActive(rs.getInt("active"));
		return blocks;
	}

}
