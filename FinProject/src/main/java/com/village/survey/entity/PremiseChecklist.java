package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "premise_checklist")
public class PremiseChecklist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long premiseChecklistId;
	private String question;
	private String value;
	private String comment;

	public long getPremiseChecklistId() {
		return premiseChecklistId;
	}

	public void setPremiseChecklistId(long premiseChecklistId) {
		this.premiseChecklistId = premiseChecklistId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PremiseChecklist [premiseChecklistId=" + premiseChecklistId + ", question=" + question + ", value="
				+ value + ", comment=" + comment + "]";
	}

}
