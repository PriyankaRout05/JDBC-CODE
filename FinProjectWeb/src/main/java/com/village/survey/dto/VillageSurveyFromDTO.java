package com.village.survey.dto;

import com.village.survey.entity.VillageSurveyFrom;

public class VillageSurveyFromDTO {

	private VillageSurveyFrom villageSurveyFrom;

	public VillageSurveyFrom getVillageSurveyFrom() {
		return villageSurveyFrom;
	}

	public void setVillageSurveyFrom(VillageSurveyFrom villageSurveyFrom) {
		this.villageSurveyFrom = villageSurveyFrom;
	}

	@Override
	public String toString() {
		return "VillageSurveyFromDTO [villageSurveyFrom=" + villageSurveyFrom + "]";
	}

}
