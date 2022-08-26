package com.village.survey.dto;

import com.village.survey.entity.RiskAndRecco;

public class RiskAndReccoDTO {
	
	private RiskAndRecco riskAndRecco;

	public RiskAndRecco getRiskAndRecco() {
		return riskAndRecco;
	}

	public void setRiskAndRecco(RiskAndRecco riskAndRecco) {
		this.riskAndRecco = riskAndRecco;
	}

	@Override
	public String toString() {
		return "RiskAndReccoDTO [riskAndRecco=" + riskAndRecco + "]";
	}
	
	
	

}
