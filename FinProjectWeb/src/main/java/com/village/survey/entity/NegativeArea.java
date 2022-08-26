package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negative_area")
public class NegativeArea implements Serializable {

	private static final long serialVersionUID = -7156529532092842710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long negativeAreaId;

	private Long negativeArea;

	@OneToMany(targetEntity = RingLeaders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ring_leaders_information_id", referencedColumnName = "negativeAreaId")
	private List<RingLeaders> ringLeaders;

	private Date createdOn;

	private Long createdUser;

	private Date modifiedOn;

	private Long modifiedUser;

	private int active;

	public Long getNegativeAreaId() {
		return negativeAreaId;
	}

	public void setNegativeAreaId(Long negativeAreaId) {
		this.negativeAreaId = negativeAreaId;
	}

	public Long getNegativeArea() {
		return negativeArea;
	}

	public void setNegativeArea(Long negativeArea) {
		this.negativeArea = negativeArea;
	}

	public List<RingLeaders> getRingLeaders() {
		return ringLeaders;
	}

	public void setRingLeaders(List<RingLeaders> ringLeaders) {
		this.ringLeaders = ringLeaders;
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
		return "NegativeArea [negativeAreaId=" + negativeAreaId + ", negativeArea=" + negativeArea + ", ringLeaders="
				+ ringLeaders + ", createdOn=" + createdOn + ", createdUser=" + createdUser + ", modifiedOn="
				+ modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active + "]";
	}

}
