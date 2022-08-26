package com.village.survey.rowmapper;
//package com.village.survey.rowmapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.village.survey.entity.MajorPARVillage;
//
//public class MajorPARVillageRowMapper implements RowMapper<MajorPARVillage> {
//
//	@Override
//	public MajorPARVillage mapRow(ResultSet rs, int rowNum) throws SQLException {
//		MajorPARVillage majorPARVillage = new MajorPARVillage();
//		majorPARVillage.setId(rs.getLong("id"));
//		majorPARVillage.setName(rs.getString("name"));
//		majorPARVillage.setClients(rs.getInt("clients"));
//		majorPARVillage.setReason(rs.getString("reason"));
//		return majorPARVillage;
//	}
//
//}
