package com.village.survey.dto;

import com.village.survey.entity.NegativeAreas;

public class NegativeAreasDTO {
	private NegativeAreas negativeAreas;

	public NegativeAreas getNegativeAreas() {
		return negativeAreas;
	}

	public void setNegativeAreas(NegativeAreas negativeAreas) {
		this.negativeAreas = negativeAreas;
	}

	@Override
	public String toString() {
		return "NegativeAreasDTO [negativeAreas=" + negativeAreas + "]";
	}
	

}
