package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "final_recommendations")
public class FinalRecommendations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long finalRecomId;
	private int branchId;
	private String byserveyor;
	private String byrm;

	public long getFinalRecomId() {
		return finalRecomId;
	}

	public void setFinalRecomId(long finalRecomId) {
		this.finalRecomId = finalRecomId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getByserveyor() {
		return byserveyor;
	}

	public void setByserveyor(String byserveyor) {
		this.byserveyor = byserveyor;
	}

	public String getByrm() {
		return byrm;
	}

	public void setByrm(String byrm) {
		this.byrm = byrm;
	}

	@Override
	public String toString() {
		return "FinalRecommendations [finalRecomId=" + finalRecomId + ", branchId=" + branchId + ", byserveyor="
				+ byserveyor + ", byrm=" + byrm + "]";
	}

}
