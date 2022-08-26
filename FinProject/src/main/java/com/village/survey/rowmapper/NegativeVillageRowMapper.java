package com.village.survey.rowmapper;
//package com.village.survey.rowmapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.village.survey.entity.NegativeVillage;
//
//public class NegativeVillageRowMapper implements RowMapper<NegativeVillage> {
//
//	@Override
//	public NegativeVillage mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//		NegativeVillage negativeVillage = new NegativeVillage();
//
//		negativeVillage.setId(rs.getLong("id"));
//		negativeVillage.setName(rs.getString("name"));
//		negativeVillage.setReason(rs.getString("reason"));
//
//		return negativeVillage;
//	}
//
//}
