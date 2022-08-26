package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.village.survey.entity.VillagePhotos;

/**
 * @author 
 *
 */
public class VillagePhotosRowMapper implements RowMapper<VillagePhotos> {

	@Override
	public VillagePhotos mapRow(ResultSet rs, int rowNum) throws SQLException {

		VillagePhotos villagePhotos = new VillagePhotos();
		villagePhotos.setId(rs.getLong("id"));
		villagePhotos.setName(rs.getString("name"));
		villagePhotos.setVillage(rs.getLong("village"));
		villagePhotos.setSurvey(rs.getLong("survey"));
		villagePhotos.setS3Url(rs.getString("s3_url"));
		villagePhotos.setCreatedOn(rs.getDate("created_on"));
		villagePhotos.setCreatedUser(rs.getLong("created_user"));
		villagePhotos.setModifiedOn(rs.getDate("modified_on"));
		villagePhotos.setModifiedUser(rs.getLong("modified_user"));
		villagePhotos.setActive(rs.getInt("active"));

		return villagePhotos;
	}

}
