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
	private Integer branchLocation;

	@OneToMany(targetEntity = PremiseInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "premise_informationid", referencedColumnName = "branchpremisesurveyId")
	private List<PremiseInformation> premiseInformation;

	@OneToMany(targetEntity = RentAndDeposites.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rentand_depositesid", referencedColumnName = "branchpremisesurveyId")
	private List<RentAndDeposites> rentAndDeposites;

	@OneToMany(targetEntity = OwnerInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_informationid", referencedColumnName = "branchpremisesurveyId")
	private List<OwnerInformation> ownerInformation;

	@OneToMany(targetEntity = HyegieneAndSafety.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "hyegieneand_safetyid", referencedColumnName = "branchpremisesurveyId")
	private List<HyegieneAndSafety> hyegieneAndSafety;

	@OneToMany(targetEntity = PremiseChecklist.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "premisechecklist_id", referencedColumnName = "branchpremisesurveyId")
	private List<PremiseChecklist> premiseChecklist;

	@OneToMany(targetEntity = PremisePhotographs.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Premise_photographsid", referencedColumnName = "branchpremisesurveyId")
	private List<PremisePhotographs> premisePhotographs;

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

	public Integer getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(Integer branchLocation) {
		this.branchLocation = branchLocation;
	}

	public List<PremiseInformation> getPremiseInformation() {
		return premiseInformation;
	}

	public void setPremiseInformation(List<PremiseInformation> premiseInformation) {
		this.premiseInformation = premiseInformation;
	}

	public List<RentAndDeposites> getRentAndDeposites() {
		return rentAndDeposites;
	}

	public void setRentAndDeposites(List<RentAndDeposites> rentAndDeposites) {
		this.rentAndDeposites = rentAndDeposites;
	}

	public List<OwnerInformation> getOwnerInformation() {
		return ownerInformation;
	}

	public void setOwnerInformation(List<OwnerInformation> ownerInformation) {
		this.ownerInformation = ownerInformation;
	}

	public List<HyegieneAndSafety> getHyegieneAndSafety() {
		return hyegieneAndSafety;
	}

	public void setHyegieneAndSafety(List<HyegieneAndSafety> hyegieneAndSafety) {
		this.hyegieneAndSafety = hyegieneAndSafety;
	}

	public List<PremiseChecklist> getPremiseChecklist() {
		return premiseChecklist;
	}

	public void setPremiseChecklist(List<PremiseChecklist> premiseChecklist) {
		this.premiseChecklist = premiseChecklist;
	}

	public List<PremisePhotographs> getPremisePhotographs() {
		return premisePhotographs;
	}

	public void setPremisePhotographs(List<PremisePhotographs> premisePhotographs) {
		this.premisePhotographs = premisePhotographs;
	}

	@Override
	public String toString() {
		return "BranchPremiseSurvey [branchPremiseSurveyId=" + branchPremiseSurveyId + ", branchName=" + branchName
				+ ", branchLocation=" + branchLocation + ", premiseInformation=" + premiseInformation
				+ ", rentAndDeposites=" + rentAndDeposites + ", ownerInformation=" + ownerInformation
				+ ", hyegieneAndSafety=" + hyegieneAndSafety + ", premiseChecklist=" + premiseChecklist
				+ ", premisePhotographs=" + premisePhotographs + "]";
	}

}
