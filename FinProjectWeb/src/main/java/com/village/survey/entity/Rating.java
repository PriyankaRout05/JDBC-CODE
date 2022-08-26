package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {

	private static final long serialVersionUID = 1209798286366789880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	private int question;
	private String businessEnviormentRating;
	private String rmsRating;
	private String rmsRecommendations;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;	
	private int active;

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getBusinessEnviormentRating() {
		return businessEnviormentRating;
	}

	public void setBusinessEnviormentRating(String businessEnviormentRating) {
		this.businessEnviormentRating = businessEnviormentRating;
	}

	public String getRmsRating() {
		return rmsRating;
	}

	public void setRmsRating(String rmsRating) {
		this.rmsRating = rmsRating;
	}

	public String getRmsRecommendations() {
		return rmsRecommendations;
	}

	public void setRmsRecommendations(String rmsRecommendations) {
		this.rmsRecommendations = rmsRecommendations;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", question=" + question + ", businessEnviormentRating="
				+ businessEnviormentRating + ", rmsRating=" + rmsRating + ", rmsRecommendations=" + rmsRecommendations
				+ ", createdOn=" + createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn
				+ ", modifiedUser=" + modifiedUser + ", active=" + active + "]";
	}

}
