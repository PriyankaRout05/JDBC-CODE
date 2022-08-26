package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "premise_information")
public class PremiseInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long premiseInformationId;
	private Integer question;
	private String value;
	private String type;
	private String comment;
	private String adress;
	private String s3Url;

	public Long getPremiseInformationId() {
		return premiseInformationId;
	}

	public void setPremiseInformationId(Long premiseInformationId) {
		this.premiseInformationId = premiseInformationId;
	}

	public Integer getQuestion() {
		return question;
	}

	public void setQuestion(Integer question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}

	@Override
	public String toString() {
		return "PremiseInformation [premiseInformationId=" + premiseInformationId + ", question=" + question
				+ ", value=" + value + ", type=" + type + ", comment=" + comment + ", adress=" + adress + ", s3Url="
				+ s3Url + "]";
	}

}
