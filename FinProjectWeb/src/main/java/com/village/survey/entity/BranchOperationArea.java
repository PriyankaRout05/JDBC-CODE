package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.village.survey.core.util.Converter;

@Entity
@Table(name = "branch_operation_area")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchOperationArea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchOperationAreaId;

	@Convert(converter = Converter.class)
	private List<String> stateId;

	@Convert(converter = Converter.class)
	private List<String> districtId;

	@Convert(converter = Converter.class)
	private List<String> blocksId;

	@Convert(converter = Converter.class)
	private List<String> pincode;

	private Date createdOn;

	private Long createdUser;

	private Date modifiedOn;

	private Long modifiedUser;

	private int active;

	private Long question;

	private String value;

	
	public int getBranchOperationAreaId() {
		return branchOperationAreaId;
	}

	public void setBranchOperationAreaId(int branchOperationAreaId) {
		this.branchOperationAreaId = branchOperationAreaId;
	}

	public List<String> getStateId() {
		return stateId;
	}

	public void setStateId(List<String> stateId) {
		this.stateId = stateId;
	}

	public List<String> getDistrictId() {
		return districtId;
	}

	public void setDistrictId(List<String> districtId) {
		this.districtId = districtId;
	}

	public List<String> getBlocksId() {
		return blocksId;
	}

	public void setBlocksId(List<String> blocksId) {
		this.blocksId = blocksId;
	}

	public List<String> getPincode() {
		return pincode;
	}

	public void setPincode(List<String> pincode) {
		this.pincode = pincode;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Long getQuestion() {
		return question;
	}

	public void setQuestion(Long question) {
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
				+ ", districtId=" + districtId + ", blocksId=" + blocksId + ", pincode=" + pincode + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + ", question=" + question + ", value=" + value + "]";
	}

}
