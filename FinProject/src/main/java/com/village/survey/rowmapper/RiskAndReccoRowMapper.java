package com.village.survey.rowmapper;
//package com.village.survey.rowmapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.village.survey.entity.FinalRecommendations;
//import com.village.survey.entity.RiskAndRecco;
//import com.village.survey.entity.RiskRecommendation;
//import com.village.survey.entity.RiskRelatedInformation;
//
//public class RiskAndReccoRowMapper implements RowMapper<RiskAndRecco> {
//
//	@Override
//	public RiskAndRecco mapRow(ResultSet rs, int rowNum) throws SQLException {
//		RiskAndRecco riskAndRecco = new RiskAndRecco();
//		riskAndRecco.setRiskandreccoId(rs.getLong("riskandreccoId"));
//
//		RiskRecommendation riskRecommendation = new RiskRecommendation();
//		riskRecommendation.setRiskRecomId(rs.getLong("riskRecomId"));
//		riskRecommendation.setCoverageOfMFIs(rs.getString("coverageOfMFIs"));
//		riskRecommendation.setBusinessEnviormentRating(rs.getString("businessEnviormentRating"));
//		riskRecommendation.setRmsRecommendation(rs.getString("rmsRecommendation"));
//
//		RiskRelatedInformation riskRelatedInformation = new RiskRelatedInformation();
//		riskRelatedInformation.setrRelatedInfoId(rs.getLong("rRelatedInfoId"));
//		riskRelatedInformation.setNegativeareas(rs.getString("negativeareas"));
//		riskRelatedInformation.setRingleaders(rs.getString("ringleaders"));
//		riskRelatedInformation.setNegativeoccupation(rs.getString("negativeoccupation"));
//		riskRelatedInformation.setOther(rs.getString("other"));
//
//		FinalRecommendations finalRecommendations = new FinalRecommendations();
//		finalRecommendations.setFinalRecomId(rs.getLong("finalRecomId"));
//		finalRecommendations.setByserveyor(rs.getString("byserveyor"));
//		finalRecommendations.setByrm(rs.getString("byrm"));
//
//		return riskAndRecco;
//	}
//}
