package com.village.survey.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SurveyQuestion implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8486903935764755895L;

	private Long id;

	private Long question;

	private Long survey;

	private int sectionNumber;

	private int orderNumber;

	private Timestamp createdOn;

	private Long createdUser;

	private Long modifiedUser;

	private Timestamp modifiedOn;

	private int active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestion() {
		return question;
	}

	public void setQuestion(Long question) {
		this.question = question;
	}

	public Long getSurvey() {
		return survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SurveyQuestion [id=" + id + ", question=" + question + ", survey=" + survey + ", sectionNumber="
				+ sectionNumber + ", orderNumber=" + orderNumber + ", createdOn=" + createdOn + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + ", modifiedOn=" + modifiedOn + ", active=" + active
				+ "]";
	}

}
