package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "riskrelated_information")
public class RiskRelatedInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long riskrelatedinfoId;
	private int branchId;
	private String negativeareas;
	private String ringleaders;
	private String negativeoccupation;
	private String other;

	public long getRiskrelatedinfoId() {
		return riskrelatedinfoId;
	}

	public void setRiskrelatedinfoId(long riskrelatedinfoId) {
		this.riskrelatedinfoId = riskrelatedinfoId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getNegativeareas() {
		return negativeareas;
	}

	public void setNegativeareas(String negativeareas) {
		this.negativeareas = negativeareas;
	}

	public String getRingleaders() {
		return ringleaders;
	}

	public void setRingleaders(String ringleaders) {
		this.ringleaders = ringleaders;
	}

	public String getNegativeoccupation() {
		return negativeoccupation;
	}

	public void setNegativeoccupation(String negativeoccupation) {
		this.negativeoccupation = negativeoccupation;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "RiskRelatedInformation [riskrelatedinfoId=" + riskrelatedinfoId + ", branchId=" + branchId
				+ ", negativeareas=" + negativeareas + ", ringleaders=" + ringleaders + ", negativeoccupation="
				+ negativeoccupation + ", other=" + other + "]";
	}

}
