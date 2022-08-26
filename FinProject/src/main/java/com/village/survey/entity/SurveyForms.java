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
@Table(name = "survey_forms")
public class SurveyForms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long surveyFormsId;

	@OneToMany(targetEntity = BranchOperationArea.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "branchoperationarea_id", referencedColumnName = "surveyFormsId")
	private List<BranchOperationArea> branchOperationArea;
	@OneToMany(targetEntity = VisitedInstitutions.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "visitedinstitutions_id", referencedColumnName = "surveyFormsId")
	private List<VisitedInstitutions> visitedInstitutions;
	@OneToMany(targetEntity = VillageVisited.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "village_visited_id", referencedColumnName = "surveyFormsId")
	private List<VillageVisited> villageVisited;
	@OneToMany(targetEntity = NegativeAreas.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negativeareas_id", referencedColumnName = "surveyFormsId")
	private List<NegativeAreas> negativeAreas;
	@OneToMany(targetEntity = NegativeOccupation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negativeoccupation_id", referencedColumnName = "surveyFormsId")
	private List<NegativeOccupation> negativeOccupation;

	@OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rating_information_id", referencedColumnName = "surveyFormsId")
	private List<Rating> rating;

	@OneToMany(targetEntity = Recommendations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "recommendations_information_id", referencedColumnName = "surveyFormsId")
	private List<Recommendations> recommendations;

	public long getSurveyFormsId() {
		return surveyFormsId;
	}

	public void setSurveyFormsId(long surveyFormsId) {
		this.surveyFormsId = surveyFormsId;
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

	public List<VillageVisited> getVillageVisited() {
		return villageVisited;
	}

	public void setVillageVisited(List<VillageVisited> villageVisited) {
		this.villageVisited = villageVisited;
	}

	public List<NegativeAreas> getNegativeAreas() {
		return negativeAreas;
	}

	public void setNegativeAreas(List<NegativeAreas> negativeAreas) {
		this.negativeAreas = negativeAreas;
	}

	public List<NegativeOccupation> getNegativeOccupation() {
		return negativeOccupation;
	}

	public void setNegativeOccupation(List<NegativeOccupation> negativeOccupation) {
		this.negativeOccupation = negativeOccupation;
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

	@Override
	public String toString() {
		return "SurveyForms [surveyFormsId=" + surveyFormsId + ", branchOperationArea=" + branchOperationArea
				+ ", visitedInstitutions=" + visitedInstitutions + ", villageVisited=" + villageVisited
				+ ", negativeAreas=" + negativeAreas + ", negativeOccupation=" + negativeOccupation + ", rating="
				+ rating + ", recommendations=" + recommendations + "]";
	}

}
