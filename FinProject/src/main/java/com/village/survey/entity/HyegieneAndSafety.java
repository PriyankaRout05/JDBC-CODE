package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hyegiene_and_safety")
public class HyegieneAndSafety {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hyegieneAndSafetyId;
	private String question;
	private String type;
	private String value;
	private String comment;

	public Long getHyegieneAndSafetyId() {
		return hyegieneAndSafetyId;
	}

	public void setHyegieneAndSafetyId(Long hyegieneAndSafetyId) {
		this.hyegieneAndSafetyId = hyegieneAndSafetyId;
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
		return "HyegieneAndSafety [hyegieneAndSafetyId=" + hyegieneAndSafetyId + ", question=" + question + ", type="
				+ type + ", value=" + value + ", comment=" + comment + "]";
	}

}
