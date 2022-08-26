package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.village.survey.core.util.CustomSerializer;



@Entity
@Table(name = "branch_premisesurvey_json")
@JsonIgnoreProperties(ignoreUnknown=true)
public class BranchPremiseSurveyJson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long branchPremiseSurveyId;
	private Integer branchName;
	private String branchLocation;
	//@JsonSerialize(using = CustomSerializer.class) 
	private String premiseSurveyJson;
	private String coordinates;
	private String s3Url;

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

	public String getPremiseSurveyJson() {
		return premiseSurveyJson;
	}

	public void setPremiseSurveyJson(String premiseSurveyJson) {
		this.premiseSurveyJson = premiseSurveyJson;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}

	@Override
	public String toString() {
		return "BranchPremiseSurveyJson [branchPremiseSurveyId=" + branchPremiseSurveyId + ", branchName=" + branchName
				+ ", branchLocation=" + branchLocation + ", premiseSurveyJson=" + premiseSurveyJson + ", coordinates="
				+ coordinates + ", s3Url=" + s3Url + "]";
	}

}
