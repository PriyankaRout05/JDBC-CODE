package com.village.survey.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	private String areaName;
	private Double areaSize;
	private String coordinates;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> adress;
	// @OneToMany(targetEntity = String.class, mappedBy = "premise_information",
	// fetch = FetchType.EAGER)
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> typeofpermise;
	private String comment;

	public Long getPremiseInformationId() {
		return premiseInformationId;
	}

	public void setPremiseInformationId(Long premiseInformationId) {
		this.premiseInformationId = premiseInformationId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Double getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(Double areaSize) {
		this.areaSize = areaSize;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public List<String> getAdress() {
		return adress;
	}

	public void setAdress(List<String> adress) {
		this.adress = adress;
	}

	public List<String> getTypeofpermise() {
		return typeofpermise;
	}

	public void setTypeofpermise(List<String> typeofpermise) {
		this.typeofpermise = typeofpermise;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PremiseInformation [premiseInformationId=" + premiseInformationId + ", areaName=" + areaName
				+ ", areaSize=" + areaSize + ", coordinates=" + coordinates + ", adress=" + adress + ", typeofpermise="
				+ typeofpermise + ", comment=" + comment + "]";
	}

}
