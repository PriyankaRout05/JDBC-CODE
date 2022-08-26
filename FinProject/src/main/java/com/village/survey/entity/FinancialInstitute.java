package com.village.survey.entity;

import java.io.Serializable;

public class FinancialInstitute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String type;
	private String name;
	private String contactPerson;
	private String contactNumber;
	private Long createdUser;
	private Long modifiedUser;
	private Long addressid;
	private Long operationaldetailsid;
	private Long majorparvillagesid;
	private Long negativevillageid;
	private int active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public Long getOperationaldetailsid() {
		return operationaldetailsid;
	}

	public void setOperationaldetailsid(Long operationaldetailsid) {
		this.operationaldetailsid = operationaldetailsid;
	}

	public Long getMajorparvillagesid() {
		return majorparvillagesid;
	}

	public void setMajorparvillagesid(Long majorparvillagesid) {
		this.majorparvillagesid = majorparvillagesid;
	}

	public Long getNegativevillageid() {
		return negativevillageid;
	}

	public void setNegativevillageid(Long negativevillageid) {
		this.negativevillageid = negativevillageid;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FinancialInstitute [id=" + id + ", type=" + type + ", name=" + name + ", contactPerson=" + contactPerson
				+ ", contactNumber=" + contactNumber + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ ", addressid=" + addressid + ", operationaldetailsid=" + operationaldetailsid
				+ ", majorparvillagesid=" + majorparvillagesid + ", negativevillageid=" + negativevillageid
				+ ", active=" + active + "]";
	}

}
