package com.village.survey.dto;

import com.village.survey.entity.SurveyData;

public class SurveyDataDTO {

	private SurveyData surveyData;

	public SurveyData getSurveyData() {
		return surveyData;
	}

	public void setSurveyData(SurveyData surveyData) {
		this.surveyData = surveyData;
	}

	@Override
	public String toString() {
		return "SurveyDataDTO [surveyData=" + surveyData + "]";
	}

}
