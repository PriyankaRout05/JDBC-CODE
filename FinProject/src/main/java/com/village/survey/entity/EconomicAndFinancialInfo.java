package com.village.survey.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "economic_and_financialinfo")
public class EconomicAndFinancialInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long econmicId;
	private String village;
	private String district;
	private String block;
	private int pincode;
	private String coordinates;
	private Timestamp time;

	public long getId() {
		return econmicId;
	}

	public void setId(long econmicId) {
		this.econmicId = econmicId;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "EconomicAndFinancialInfo [econmicId=" + econmicId + ", village=" + village + ", district=" + district
				+ ", block=" + block + ", pincode=" + pincode + ", coordinates=" + coordinates + ", time=" + time + "]";
	}

}
