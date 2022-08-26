package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.FinancialInstitutions;

/**
 * @author
 *
 */
public class FinancialInstitutionsRowMapper implements RowMapper<FinancialInstitutions> {

	@Override
	public FinancialInstitutions mapRow(ResultSet rs, int rowNum) throws SQLException {

		FinancialInstitutions financialInstitutions = new FinancialInstitutions();
		financialInstitutions.setId(rs.getLong("id"));
		financialInstitutions.setName(rs.getString("name"));
		financialInstitutions.setType(rs.getString("type"));
		financialInstitutions.setContactPerson(rs.getString("contact_person"));
		financialInstitutions.setMobileNumber(rs.getLong("mobile_number"));
		financialInstitutions.setAddress(rs.getString("address"));
		financialInstitutions.setOperatingSince(rs.getDate("operating_since"));
		financialInstitutions.setCreatedOn(rs.getDate("created_on"));
		financialInstitutions.setCreatedUser(rs.getLong("created_user"));
		financialInstitutions.setModifiedOn(rs.getDate("modified_on"));
		financialInstitutions.setModifiedUser(rs.getLong("modified_user"));
		financialInstitutions.setActive(rs.getInt("active"));

		return financialInstitutions;
	}

}
