package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposedbranch_location ")
public class ProposedBranchLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long propBranchLocationId;
	private int branchId;
	private String option1;
	private String option2;
	private int mandalId;

	public long getPropBranchLocationId() {
		return propBranchLocationId;
	}

	public void setPropBranchLocationId(long propBranchLocationId) {
		this.propBranchLocationId = propBranchLocationId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public int getMandalId() {
		return mandalId;
	}

	public void setMandalId(int mandalId) {
		this.mandalId = mandalId;
	}

	@Override
	public String toString() {
		return "ProposedBranchLocation [propBranchLocationId=" + propBranchLocationId + ", branchId=" + branchId
				+ ", option1=" + option1 + ", option2=" + option2 + ", mandalId=" + mandalId + "]";
	}

}
