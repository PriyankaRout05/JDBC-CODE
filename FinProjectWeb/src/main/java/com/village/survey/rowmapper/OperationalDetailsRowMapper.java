package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.OperationalDetails;

public class OperationalDetailsRowMapper implements RowMapper<OperationalDetails> {

	@Override
	public OperationalDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		OperationalDetails operationalDetails = new OperationalDetails();
		operationalDetails.setOperationalDetailsId(rs.getLong("operational_details_id"));
		operationalDetails.setClientDetail(rs.getLong("client_detail"));
		operationalDetails.setPos(rs.getBigDecimal("pos"));
		operationalDetails.setPar(rs.getBigDecimal("par"));
		operationalDetails.setAmtPar(rs.getBigDecimal("amt_par"));
		operationalDetails.setCreatedOn(rs.getDate("created_on"));
		operationalDetails.setCreatedUser(rs.getLong("created_user"));
		operationalDetails.setModifiedOn(rs.getDate("modified_on"));
		operationalDetails.setModifiedUser(rs.getLong("modified_user"));
		operationalDetails.setActive(rs.getInt("active"));

		return operationalDetails;
	}

}
