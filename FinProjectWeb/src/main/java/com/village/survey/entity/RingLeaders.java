package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ring_leaders")
public class RingLeaders implements Serializable{

	private static final long serialVersionUID = 42788394346052959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ringLeadersId;
	private String ringLeader;
	private String identifier1;
	private String identifier2;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getRingLeadersId() {
		return ringLeadersId;
	}

	public void setRingLeadersId(Long ringLeadersId) {
		this.ringLeadersId = ringLeadersId;
	}

	public String getRingLeader() {
		return ringLeader;
	}

	public void setRingLeader(String ringLeader) {
		this.ringLeader = ringLeader;
	}

	public String getIdentifier1() {
		return identifier1;
	}

	public void setIdentifier1(String identifier1) {
		this.identifier1 = identifier1;
	}

	public String getIdentifier2() {
		return identifier2;
	}

	public void setIdentifier2(String identifier2) {
		this.identifier2 = identifier2;
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
		return "RingLeaders [ringLeadersId=" + ringLeadersId + ", ringLeader=" + ringLeader + ", identifier1="
				+ identifier1 + ", identifier2=" + identifier2 + ", createdOn=" + createdOn + ", createdUser="
				+ createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ "]";
	}

}
