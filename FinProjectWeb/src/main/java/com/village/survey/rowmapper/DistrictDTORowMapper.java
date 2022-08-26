package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.dto.MandalPincodeDTO;

public class DistrictDTORowMapper implements RowMapper<MandalPincodeDTO>{

	@Override
	public MandalPincodeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MandalPincodeDTO mandalpincodeDto = new MandalPincodeDTO();
		mandalpincodeDto.setDistrictid(rs.getLong("district_id"));
		mandalpincodeDto.setMandalid(rs.getLong("mandal_id"));
		mandalpincodeDto.setMandalName(rs.getString("mandal_name"));
		mandalpincodeDto.setPincode(rs.getLong("village_pincode"));
		return mandalpincodeDto;	
	}

}
