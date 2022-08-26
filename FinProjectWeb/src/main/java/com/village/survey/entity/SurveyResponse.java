package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author vamsir
 *
 */
public class SurveyResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long surveyQuestion;
	private Long option;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOption() {
		return option;
	}

	public void setOption(Long option) {
		this.option = option;
	}

	public Long getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(Long surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
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

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SurveyResponse [id=" + id + ", surveyQuestion=" + surveyQuestion + ", option=" + option + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + "]";
	}

}
