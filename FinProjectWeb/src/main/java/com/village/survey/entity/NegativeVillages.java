package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negative_villages")
public class NegativeVillages implements Serializable {

	private static final long serialVersionUID = 921320073487314908L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long negativeVillagesId;
	private String villageName;
	private String negativeReason;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getNegativeVillagesId() {
		return negativeVillagesId;
	}

	public void setNegativeVillagesId(Long negativeVillagesId) {
		this.negativeVillagesId = negativeVillagesId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getNegativeReason() {
		return negativeReason;
	}

	public void setNegativeReason(String negativeReason) {
		this.negativeReason = negativeReason;
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
		return "NegativeVillages [negativeVillagesId=" + negativeVillagesId + ", villageName=" + villageName
				+ ", negativeReason=" + negativeReason + ", createdOn=" + createdOn + ", createdUser=" + createdUser
				+ ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active + "]";
	}

}
