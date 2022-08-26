package com.village.survey.dto;

import java.io.Serializable;

public class VillageDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String villageName;

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VillageDTO [villageName=" + villageName + "]";
	}
	
	
	
}
