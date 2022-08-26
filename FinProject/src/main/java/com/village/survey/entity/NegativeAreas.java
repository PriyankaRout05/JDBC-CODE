package com.village.survey.entity;

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
@Table(name = "negative_areas")
public class NegativeAreas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long negativeId;
	private long branchId;
	private String name;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;
	private String others;
	@OneToMany(targetEntity = RingLeaders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ring_leaders", referencedColumnName = "negativeId")
	private List<RingLeaders> ringLeaders;

	public long getNegativeId() {
		return negativeId;
	}

	public void setNegativeId(long negativeId) {
		this.negativeId = negativeId;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public List<RingLeaders> getRingLeaders() {
		return ringLeaders;
	}

	public void setRingLeaders(List<RingLeaders> ringLeaders) {
		this.ringLeaders = ringLeaders;
	}

	@Override
	public String toString() {
		return "NegativeAreas [negativeId=" + negativeId + ", branchId=" + branchId + ", name=" + name + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + ", others=" + others + ", ringLeaders=" + ringLeaders + "]";
	}

}
