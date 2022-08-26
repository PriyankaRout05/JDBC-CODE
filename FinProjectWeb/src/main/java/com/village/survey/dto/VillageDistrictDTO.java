package com.village.survey.dto;

import java.io.Serializable;

public class VillageDistrictDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String districtName;
	private String mandalName;
	private Long villagePincode;
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public Long getVillagePincode() {
		return villagePincode;
	}
	public void setVillagePincode(Long villagePincode) {
		this.villagePincode = villagePincode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "VillageDistrictDTO [districtName=" + districtName + ", mandalName=" + mandalName + ", villagePincode="
				+ villagePincode + "]";
	}
	
	
}
