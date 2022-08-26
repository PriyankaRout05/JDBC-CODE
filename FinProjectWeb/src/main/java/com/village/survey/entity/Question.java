package com.village.survey.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6236295447187353358L;

	private Long id;

	private String question;

	private String type;

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "Question [id=" + id + ", question=" + question + ", type=" + type + ", createdOn=" + createdOn
				+ ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + ", modifiedOn=" + modifiedOn
				+ ", active=" + active + "]";
	}

}
