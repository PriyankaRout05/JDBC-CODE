package com.village.survey.rowmapper;
//package com.village.survey.rowmapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.jdbc.core.RowMapper;
//import com.village.survey.entity.FinancialInfo;
//import com.village.survey.entity.MajorPARVillage;
//import com.village.survey.entity.NegativeVillage;
//import com.village.survey.entity.OperationalDetails;
//
//public class FinancialInfoRowMapper implements RowMapper<FinancialInfo> {
//
//	@Override
//	public FinancialInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//		
//		FinancialInfo financialInfo = new FinancialInfo();
//		
//		financialInfo.setId(rs.getLong("id"));
//		financialInfo.setName(rs.getString("name"));
//		financialInfo.setType(rs.getString("type"));
//		financialInfo.setContactPerson(rs.getString("contact_person"));
//		financialInfo.setContactNumber(rs.getLong("Contact_number"));
//		financialInfo.setAddress(rs.getString("address"));
//		financialInfo.setOperatingSince(rs.getDate("operating_since"));
//
//		
//		
//		List<OperationalDetails> od =new ArrayList<>();
//		OperationalDetails operationalDetails = new OperationalDetails();
//		operationalDetails.setId(rs.getLong("id"));
//		operationalDetails.setClientDetail(rs.getLong("client_detail"));
//		operationalDetails.setPos(rs.getFloat("pos"));
//		operationalDetails.setPar(rs.getFloat("par"));
//		operationalDetails.setAmtPar(rs.getFloat("amtpar"));
//		od.add(operationalDetails);
//		financialInfo.setOperationalDetails(od);
//
//		
//		List<MajorPARVillage> ml =new ArrayList<>();
//		MajorPARVillage majorPARVillage = new MajorPARVillage();
//		majorPARVillage.setId(rs.getLong("id"));
//		majorPARVillage.setName(rs.getString("name"));
//		majorPARVillage.setClients(rs.getInt("clients"));
//		majorPARVillage.setReason(rs.getString("reason"));
//		ml.add(majorPARVillage);
//		financialInfo.setMajorPARVillage(ml);;
//		
//
//		List<NegativeVillage> nl =new ArrayList<>();
//		NegativeVillage negativeVillage = new NegativeVillage();
//		negativeVillage.setId(rs.getLong("id"));
//		negativeVillage.setName(rs.getString("name"));
//		negativeVillage.setReason(rs.getString("reason"));
//		nl.add(negativeVillage);
//		financialInfo.setNegativeVillage(nl);
//		return financialInfo;
//	}
//
//}
