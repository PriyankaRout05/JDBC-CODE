package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "key_findings")
public class KeyFindings implements Serializable {

	private static final long serialVersionUID = -6646563839356924943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long keyFindingsId;
	private String parameters;
	private Long expectedValue;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getKeyFindingsId() {
		return keyFindingsId;
	}

	public void setKeyFindingsId(Long keyFindingsId) {
		this.keyFindingsId = keyFindingsId;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Long getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(Long expectedValue) {
		this.expectedValue = expectedValue;
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
		return "KeyFindings [keyFindingsId=" + keyFindingsId + ", parameters=" + parameters + ", expectedValue="
				+ expectedValue + ", createdOn=" + createdOn + ", createdUser=" + createdUser + ", modifiedOn="
				+ modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active + "]";
	}

}
