package com.village.survey.entity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "branch_operation_area")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchOperationArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long branchOperationAreaId;
	private long stateId;
	private long districtId;
	private long mandalId;
	@Convert(converter = com.village.survey.dto.Converter.class)
	private List<String> pincode;
	private int question;
	private String value;

	public long getBranchOperationAreaId() {
		return branchOperationAreaId;
	}

	public void setBranchOperationAreaId(long branchOperationAreaId) {
		this.branchOperationAreaId = branchOperationAreaId;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getMandalId() {
		return mandalId;
	}

	public void setMandalId(long mandalId) {
		this.mandalId = mandalId;
	}

	public List<String> getPincode() {
		return pincode;
	}

	public void setPincode(List<String> pincode) {
		this.pincode = pincode;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "BranchOperationArea [branchOperationAreaId=" + branchOperationAreaId + ", stateId=" + stateId
				+ ", districtId=" + districtId + ", mandalId=" + mandalId + ", pincode=" + pincode + ", question="
				+ question + ", value=" + value + "]";
	}

}
