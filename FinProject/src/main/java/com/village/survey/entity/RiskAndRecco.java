package com.village.survey.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "risk_and_recco")
public class RiskAndRecco {
	@Id
	private long riskandreccoId;
	private int branchId;

	@OneToMany(targetEntity = RiskRecommendation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "risk_recommendation_id", referencedColumnName = "riskAndReccoId")
	private List<RiskRecommendation> riskRecommendation;

	@OneToMany(targetEntity = RiskRelatedInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "riskrelated_information_id", referencedColumnName = "riskAndReccoId")
	private List<RiskRelatedInformation> riskRelatedInformation;

	@OneToMany(targetEntity = FinalRecommendations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "final_recommendations_id", referencedColumnName = "riskAndReccoId")
	private List<FinalRecommendations> finalRecommendations;

	public long getRiskandreccoId() {
		return riskandreccoId;
	}

	public void setRiskandreccoId(long riskandreccoId) {
		this.riskandreccoId = riskandreccoId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public List<RiskRecommendation> getRiskRecommendation() {
		return riskRecommendation;
	}

	public void setRiskRecommendation(List<RiskRecommendation> riskRecommendation) {
		this.riskRecommendation = riskRecommendation;
	}

	public List<RiskRelatedInformation> getRiskRelatedInformation() {
		return riskRelatedInformation;
	}

	public void setRiskRelatedInformation(List<RiskRelatedInformation> riskRelatedInformation) {
		this.riskRelatedInformation = riskRelatedInformation;
	}

	public List<FinalRecommendations> getFinalRecommendations() {
		return finalRecommendations;
	}

	public void setFinalRecommendations(List<FinalRecommendations> finalRecommendations) {
		this.finalRecommendations = finalRecommendations;
	}

	@Override
	public String toString() {
		return "RiskAndRecco [riskandreccoId=" + riskandreccoId + ", branchId=" + branchId + ", riskRecommendation="
				+ riskRecommendation + ", riskRelatedInformation=" + riskRelatedInformation + ", finalRecommendations="
				+ finalRecommendations + "]";
	}

}
