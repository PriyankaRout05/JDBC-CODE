package com.village.survey.dto;

import com.village.survey.entity.SurveyForms;

public class SurveyFormsDTO {
	private SurveyForms surveyForms;

	public SurveyForms getSurveyForms() {
		return surveyForms;
	}

	public void setSurveyForms(SurveyForms surveyForms) {
		this.surveyForms = surveyForms;
	}

	@Override
	public String toString() {
		return "SurveyFormsDTO [surveyForms=" + surveyForms + "]";
	}

}
