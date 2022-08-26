package com.village.survey.dto;

public class MandalPincodeDTO {
	
	private Long districtid;
	private Long mandalid;
	private String mandalName;
	private Long pincode;
	
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	public Long getMandalid() {
		return mandalid;
	}
	public void setMandalid(Long mandalid) {
		this.mandalid = mandalid;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

}
