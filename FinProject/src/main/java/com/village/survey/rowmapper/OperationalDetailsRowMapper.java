package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.OperationalDetails;

public class OperationalDetailsRowMapper implements RowMapper<OperationalDetails> {

	@Override
	public OperationalDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		OperationalDetails operationalDetails = new OperationalDetails();
		operationalDetails.setId(rs.getLong("id"));
		operationalDetails.setClientDetail(rs.getLong("client_detail"));
		operationalDetails.setPos(rs.getFloat("pos"));
		operationalDetails.setPar(rs.getFloat("par"));
		operationalDetails.setAmtPar(rs.getFloat("amt_par"));
		return operationalDetails;
	}

}
