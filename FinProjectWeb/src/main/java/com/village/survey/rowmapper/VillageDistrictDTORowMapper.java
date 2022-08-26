package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.dto.VillageDistrictDTO;

public class VillageDistrictDTORowMapper implements RowMapper<VillageDistrictDTO>{

	@Override
	public VillageDistrictDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		VillageDistrictDTO villageDistrictDto=new VillageDistrictDTO();
		villageDistrictDto.setDistrictName(rs.getString("district_name"));
		villageDistrictDto.setMandalName(rs.getString("mandal_name"));
		villageDistrictDto.setVillagePincode(rs.getLong("village_pincode"));
		
		return villageDistrictDto;
	}

}
