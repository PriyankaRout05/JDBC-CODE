package com.village.survey.dto;

import com.village.survey.entity.FinancialInfo;

public class FinancialinfoDTO {

	private FinancialInfo financialInfo;

	public FinancialInfo getFinancialInfo() {
		return financialInfo;
	}

	public void setFinancialInfo(FinancialInfo financialInfo) {
		this.financialInfo = financialInfo;
	}

	@Override
	public String toString() {
		return "FinancialinfoDTO [financialInfo=" + financialInfo + "]";
	}

}
