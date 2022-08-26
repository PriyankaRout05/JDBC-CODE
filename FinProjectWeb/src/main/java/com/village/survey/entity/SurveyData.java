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
@Table(name = "survey_data")
public class SurveyData implements Serializable {

	private static final long serialVersionUID = 2125712255506563379L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long surveyDataId;

	private Long branchName;

	private Long districtName;

	private Long blockName;

	@OneToMany(targetEntity = BranchOperationArea.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_operation_area_information_id", referencedColumnName = "surveyDataId")
	private List<BranchOperationArea> branchOperationArea;

	@OneToMany(targetEntity = VisitedInstitutions.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "visited_institutions_information_id", referencedColumnName = "surveyDataId")
	private List<VisitedInstitutions> visitedInstitutions;

	@OneToMany(targetEntity = VisitedVillages.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "visited_villages_information_id", referencedColumnName = "surveyDataId")
	private List<VisitedVillages> visitedVillages;

	@OneToMany(targetEntity = NegativeArea.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negative_area_infromation_id", referencedColumnName = "surveyDataId")
	private List<NegativeArea> negativeArea;

	@OneToMany(targetEntity = NegativeOccupations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negative_occupations_information_id", referencedColumnName = "surveyDataId")
	private List<NegativeOccupations> negativeOccupations;

	@OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rating_information_id", referencedColumnName = "surveydataId")
	private List<Rating> rating;

	@OneToMany(targetEntity = Recommendations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "recommendations_information_id", referencedColumnName = "surveyDataId")
	private List<Recommendations> recommendations;

	private Date createdOn;

	private Long createdUser;

	private Date modifiedOn;

	private Long modifiedUser;

	private int active;

	public Long getSurveyDataId() {
		return surveyDataId;
	}

	public void setSurveyDataId(Long surveyDataId) {
		this.surveyDataId = surveyDataId;
	}

	public List<BranchOperationArea> getBranchOperationArea() {
		return branchOperationArea;
	}

	public void setBranchOperationArea(List<BranchOperationArea> branchOperationArea) {
		this.branchOperationArea = branchOperationArea;
	}

	public List<VisitedInstitutions> getVisitedInstitutions() {
		return visitedInstitutions;
	}

	public void setVisitedInstitutions(List<VisitedInstitutions> visitedInstitutions) {
		this.visitedInstitutions = visitedInstitutions;
	}

	public List<VisitedVillages> getVisitedVillages() {
		return visitedVillages;
	}

	public void setVisitedVillages(List<VisitedVillages> visitedVillages) {
		this.visitedVillages = visitedVillages;
	}

	public List<NegativeArea> getNegativeArea() {
		return negativeArea;
	}

	public void setNegativeArea(List<NegativeArea> negativeArea) {
		this.negativeArea = negativeArea;
	}

	public List<NegativeOccupations> getNegativeOccupations() {
		return negativeOccupations;
	}

	public void setNegativeOccupations(List<NegativeOccupations> negativeOccupations) {
		this.negativeOccupations = negativeOccupations;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<Recommendations> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendations> recommendations) {
		this.recommendations = recommendations;
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

	public Long getBranchName() {
		return branchName;
	}

	public void setBranchName(Long branchName) {
		this.branchName = branchName;
	}

	public Long getDistrictName() {
		return districtName;
	}

	public void setDistrictName(Long districtName) {
		this.districtName = districtName;
	}

	public Long getBlockName() {
		return blockName;
	}

	public void setBlockName(Long blockName) {
		this.blockName = blockName;
	}

	@Override
	public String toString() {
		return "SurveyData [surveyDataId=" + surveyDataId + ", branchName=" + branchName + ", districtName="
				+ districtName + ", blockName=" + blockName + ", branchOperationArea=" + branchOperationArea
				+ ", visitedInstitutions=" + visitedInstitutions + ", visitedVillages=" + visitedVillages
				+ ", negativeArea=" + negativeArea + ", negativeOccupations=" + negativeOccupations + ", rating="
				+ rating + ", recommendations=" + recommendations + ", createdOn=" + createdOn + ", createdUser="
				+ createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ "]";
	}

}
