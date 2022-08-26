package com.village.survey.dto;

import com.village.survey.entity.BranchPremiseSurveyJson;

public class BranchPremiseSurveyJsonDTO {

	private BranchPremiseSurveyJson branchPremiseSurveyJson;

	public BranchPremiseSurveyJson getBranchPremiseSurveyJson() {
		return branchPremiseSurveyJson;
	}

	public void setBranchPremiseSurveyJson(BranchPremiseSurveyJson branchPremiseSurveyJson) {
		this.branchPremiseSurveyJson = branchPremiseSurveyJson;
	}

	@Override
	public String toString() {
		return "BranchPremiseSurveyJsonDTO [branchPremiseSurveyJson=" + branchPremiseSurveyJson + "]";
	}

}
