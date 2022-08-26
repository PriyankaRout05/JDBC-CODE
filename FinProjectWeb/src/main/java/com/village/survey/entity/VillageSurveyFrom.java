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
@Table(name = "village_survey_from")
public class VillageSurveyFrom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long villageSurveyFromId;
	private int villaegId;
	private Long noOfHouseholds;

	@OneToMany(targetEntity = VillageInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "villageinformation_id", referencedColumnName = "villageSurveyFromId")
	private List<VillageInformation> villageInformation;

	@OneToMany(targetEntity = VillageSurvey.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "villagesurvey_id", referencedColumnName = "villageSurveyFromId")
	private List<VillageSurvey> villageSurvey;

	public Long getVillageSurveyFromId() {
		return villageSurveyFromId;
	}

	public void setVillageSurveyFromId(Long villageSurveyFromId) {
		this.villageSurveyFromId = villageSurveyFromId;
	}

	public int getVillaegId() {
		return villaegId;
	}

	public void setVillaegId(int villaegId) {
		this.villaegId = villaegId;
	}

	public Long getNoOfHouseholds() {
		return noOfHouseholds;
	}

	public void setNoOfHouseholds(Long noOfHouseholds) {
		this.noOfHouseholds = noOfHouseholds;
	}

	public List<VillageInformation> getVillageInformation() {
		return villageInformation;
	}

	public void setVillageInformation(List<VillageInformation> villageInformation) {
		this.villageInformation = villageInformation;
	}

	public List<VillageSurvey> getVillageSurvey() {
		return villageSurvey;
	}

	public void setVillageSurvey(List<VillageSurvey> villageSurvey) {
		this.villageSurvey = villageSurvey;
	}

	@Override
	public String toString() {
		return "VillageSurveyFrom [villageSurveyFromId=" + villageSurveyFromId + ", villaegId=" + villaegId
				+ ", noOfHouseholds=" + noOfHouseholds + ", villageInformation=" + villageInformation
				+ ", villageSurvey=" + villageSurvey + "]";
	}

}
