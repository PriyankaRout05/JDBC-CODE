package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.dto.VillageDTO;

public class VillageDTORowMapper implements RowMapper<VillageDTO> {

	@Override
	public VillageDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		VillageDTO villageDto=new VillageDTO();
		villageDto.setVillageName(rs.getString("village_name"));
		return villageDto;
	}

}
