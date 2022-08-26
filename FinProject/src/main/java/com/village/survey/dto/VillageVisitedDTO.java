package com.village.survey.dto;

import com.village.survey.entity.VillageVisited;

public class VillageVisitedDTO {
	
	private VillageVisited villageVisited;

	public VillageVisited getVillageVisited() {
		return villageVisited;
	}

	public void setVillageVisited(VillageVisited villageVisited) {
		this.villageVisited = villageVisited;
	}

	@Override
	public String toString() {
		return "VillageVisitedDTO [villageVisited=" + villageVisited + "]";
	}
	
	

}
