package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.dto.BranchDTO;
import com.village.survey.dto.DistrictDTO;
import com.village.survey.dto.MandalDTO;
import com.village.survey.entity.State;

public class BranchDTORowMapper implements RowMapper<BranchDTO> {

	@Override
	public BranchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BranchDTO branchDTO=new BranchDTO();
		
		branchDTO.setBranchId(rs.getLong("branch_id"));
		branchDTO.setBranchName(rs.getString("branch_name"));
		
		DistrictDTO dist=new DistrictDTO();
		dist.setId(rs.getLong("district_id"));
		dist.setName(rs.getString("district_name"));
		
		State state=new State();
		state.setId(rs.getLong("state_id"));
		state.setName(rs.getString("state_name"));
		
		MandalDTO mandalDto = new MandalDTO();
		mandalDto.setId(rs.getLong("mandal_id"));
		mandalDto.setName(rs.getString("mandal_name"));
		mandalDto.setDistrict(dist);
		dist.setState(state);
		
		branchDTO.setMandal(mandalDto);
		
		return branchDTO;
	}

}


