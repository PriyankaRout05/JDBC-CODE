package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "village_survey")
public class VillageSurvey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long villageSurveyId;
	private Integer question;
	private String value;
	private String option;

	public Long getVillageSurveyId() {
		return villageSurveyId;
	}

	public void setVillageSurveyId(Long villageSurveyId) {
		this.villageSurveyId = villageSurveyId;
	}

	public Integer getQuestion() {
		return question;
	}

	public void setQuestion(Integer question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "VillageSurvey [villageSurveyId=" + villageSurveyId + ", question=" + question + ", value=" + value
				+ ", option=" + option + "]";
	}

}
