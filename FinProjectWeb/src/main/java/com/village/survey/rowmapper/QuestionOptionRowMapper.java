package com.village.survey.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.village.survey.dto.OptionDTO;
import com.village.survey.entity.QuestionOption;

/**
 * 
 * @author vamsir
 *
 */
public class QuestionOptionRowMapper implements RowMapper<QuestionOption> {

	@Override
	public QuestionOption mapRow(ResultSet rs, int rowNum) throws SQLException {

		QuestionOption option = new QuestionOption();
		option.setId(rs.getLong("id"));
		option.setOption(rs.getString("option"));
		option.setValue(rs.getString("value"));
		option.setQuestion(rs.getLong("question"));
		option.setCreatedOn(rs.getDate("created_on"));
		option.setCreatedUser(rs.getLong("created_user"));
		option.setModifiedOn(rs.getDate("modified_on"));
		option.setModifiedUser(rs.getLong("modified_user"));
		option.setActive(rs.getInt("active"));
		String[] optionsArray = rs.getString("option").replace("[", "").replace("]", "").split(",");
		List<OptionDTO> list = new ArrayList<>();
		for (String value : optionsArray) {
			OptionDTO optionDto = new OptionDTO();
			optionDto.setOption(value);
			list.add(optionDto);
		}

		ObjectMapper objMapper = new ObjectMapper();
		try {
			option.setOption(objMapper.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return option;
	}
}
