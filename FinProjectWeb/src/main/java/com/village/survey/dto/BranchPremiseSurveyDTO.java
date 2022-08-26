package com.village.survey.dto;

import com.village.survey.entity.BranchPremiseSurvey;

public class BranchPremiseSurveyDTO {

	private BranchPremiseSurvey branchPremiseSurvey;

	public BranchPremiseSurvey getBranchPremiseSurvey() {
		return branchPremiseSurvey;
	}

	public void setBranchPremiseSurvey(BranchPremiseSurvey branchPremiseSurvey) {
		this.branchPremiseSurvey = branchPremiseSurvey;
	}

	@Override
	public String toString() {
		return "BranchPremiseSurveyDTO [branchPremiseSurvey=" + branchPremiseSurvey + "]";
	}

}