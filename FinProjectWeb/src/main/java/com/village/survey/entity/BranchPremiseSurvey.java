package com.village.survey.entity;

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
@Table(name = "branch_premise_survey")
public class BranchPremiseSurvey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long branchPremiseSurveyId;
	private Integer branchName;
	private String branchLocation;

	@OneToMany(targetEntity = PremiseInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "premise_informationid", referencedColumnName = "branchpremisesurveyId")
	private List<PremiseInformation> premiseInformation;

	public long getBranchPremiseSurveyId() {
		return branchPremiseSurveyId;
	}

	public void setBranchPremiseSurveyId(long branchPremiseSurveyId) {
		this.branchPremiseSurveyId = branchPremiseSurveyId;
	}

	public Integer getBranchName() {
		return branchName;
	}

	public void setBranchName(Integer branchName) {
		this.branchName = branchName;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public List<PremiseInformation> getPremiseInformation() {
		return premiseInformation;
	}

	public void setPremiseInformation(List<PremiseInformation> premiseInformation) {
		this.premiseInformation = premiseInformation;
	}

	@Override
	public String toString() {
		return "BranchPremiseSurvey [branchPremiseSurveyId=" + branchPremiseSurveyId + ", branchName=" + branchName
				+ ", branchLocation=" + branchLocation + ", premiseInformation=" + premiseInformation + "]";
	}

}
