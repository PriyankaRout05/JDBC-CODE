package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negative_occupation_information")
public class NegativeOccupationsInformation implements Serializable {

	private static final long serialVersionUID = 1652758802389314658L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int negativeOccupationInformationId;
	private String negativeOccupation;
	private String area;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public int getNegativeOccupationInformationId() {
		return negativeOccupationInformationId;
	}

	public void setNegativeOccupationInformationId(int negativeOccupationInformationId) {
		this.negativeOccupationInformationId = negativeOccupationInformationId;
	}

	public String getNegativeOccupation() {
		return negativeOccupation;
	}

	public void setNegativeOccupation(String negativeOccupation) {
		this.negativeOccupation = negativeOccupation;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	@Override
	public String toString() {
		return "NegativeOccupationsInformation [negativeOccupationInformationId=" + negativeOccupationInformationId
				+ ", negativeOccupation=" + negativeOccupation + ", area=" + area + ", createdOn=" + createdOn
				+ ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser
				+ ", active=" + active + "]";
	}

}
