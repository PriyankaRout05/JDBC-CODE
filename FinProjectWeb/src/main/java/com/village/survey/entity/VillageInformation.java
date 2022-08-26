package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "village_information")

public class VillageInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long villageInformationId;
	private long villaegId;
	private int districtId;
	private int blockId;
	private int panchayathId;
	private String route;
	private int pincode;
	private int villageClassificationId;
	private String s3Url;

	public Long getVillageInformationId() {
		return villageInformationId;
	}

	public void setVillageInformationId(Long villageInformationId) {
		this.villageInformationId = villageInformationId;
	}

	public long getVillaegId() {
		return villaegId;
	}

	public void setVillaegId(long villaegId) {
		this.villaegId = villaegId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public int getPanchayathId() {
		return panchayathId;
	}

	public void setPanchayathId(int panchayathId) {
		this.panchayathId = panchayathId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getVillageClassificationId() {
		return villageClassificationId;
	}

	public void setVillageClassificationId(int villageClassificationId) {
		this.villageClassificationId = villageClassificationId;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}

	@Override
	public String toString() {
		return "VillageInformation [villageInformationId=" + villageInformationId + ", villaegId=" + villaegId
				+ ", districtId=" + districtId + ", blockId=" + blockId + ", panchayathId=" + panchayathId + ", route="
				+ route + ", pincode=" + pincode + ", villageClassificationId=" + villageClassificationId + ", s3Url="
				+ s3Url + "]";
	}

}
