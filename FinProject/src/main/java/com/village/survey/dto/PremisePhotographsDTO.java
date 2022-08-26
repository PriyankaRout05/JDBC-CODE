package com.village.survey.dto;

import com.village.survey.entity.PremisePhotographs;

public class PremisePhotographsDTO {

	private PremisePhotographs premisePhotographs;

	public PremisePhotographs getPremisePhotographs() {
		return premisePhotographs;
	}

	public void setPremisePhotographs(PremisePhotographs premisePhotographs) {
		this.premisePhotographs = premisePhotographs;
	}

	@Override
	public String toString() {
		return "PremisePhotographsDTO [premisePhotographs=" + premisePhotographs + "]";
	}

}
