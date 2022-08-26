package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "risk_recommendation")
public class RiskRecommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long riskrecomId;
	private int branchId;
	private String coverageOfMFIs;
	private String businessEnviormentRating;
	private String rmsRecommendation;

	public long getRiskrecomId() {
		return riskrecomId;
	}

	public void setRiskrecomId(long riskrecomId) {
		this.riskrecomId = riskrecomId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCoverageOfMFIs() {
		return coverageOfMFIs;
	}

	public void setCoverageOfMFIs(String coverageOfMFIs) {
		this.coverageOfMFIs = coverageOfMFIs;
	}

	public String getBusinessEnviormentRating() {
		return businessEnviormentRating;
	}

	public void setBusinessEnviormentRating(String businessEnviormentRating) {
		this.businessEnviormentRating = businessEnviormentRating;
	}

	public String getRmsRecommendation() {
		return rmsRecommendation;
	}

	public void setRmsRecommendation(String rmsRecommendation) {
		this.rmsRecommendation = rmsRecommendation;
	}

	@Override
	public String toString() {
		return "RiskRecommendation [riskrecomId=" + riskrecomId + ", branchId=" + branchId + ", coverageOfMFIs="
				+ coverageOfMFIs + ", businessEnviormentRating=" + businessEnviormentRating + ", rmsRecommendation="
				+ rmsRecommendation + "]";
	}

}
