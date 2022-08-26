package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.FinancialInstitute;

public class FinancialInstituteRowmapper implements RowMapper<FinancialInstitute> {

	@Override
	public FinancialInstitute mapRow(ResultSet rs, int rowNum) throws SQLException {

		FinancialInstitute financialInstitute = new FinancialInstitute();
		financialInstitute.setId(rs.getLong("id"));
		financialInstitute.setName(rs.getString("name"));
		financialInstitute.setType(rs.getString("type"));
		financialInstitute.setContactPerson(rs.getString("contact_person"));
		financialInstitute.setContactNumber(rs.getString("contact_number"));
		financialInstitute.setCreatedUser(rs.getLong("created_user"));
		financialInstitute.setModifiedUser(rs.getLong("modified_user"));
		financialInstitute.setAddressid(rs.getLong("address_id"));
		financialInstitute.setOperationaldetailsid(rs.getLong("operationaldetails_id"));
		financialInstitute.setMajorparvillagesid(rs.getLong("negativevillage_id"));
		financialInstitute.setActive(rs.getInt(rs.getInt("active")));

		return financialInstitute;

	}
}
