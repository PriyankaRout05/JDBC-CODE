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
@Table(name = "negative_occupation")
public class NegativeOccupation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long negativeOccupationId;
	private String negativeOccupationName;
	private String area;
	@OneToMany(targetEntity = NegativeOccupationInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negativeoccupationinfo_id", referencedColumnName = "negativeOccupationId")
	private List<NegativeOccupationInfo> negativeOccupationInfo;
	private String otherInformation;
	private String assessedRisk;
	public long getNegativeOccupationId() {
		return negativeOccupationId;
	}
	public void setNegativeOccupationId(long negativeOccupationId) {
		this.negativeOccupationId = negativeOccupationId;
	}
	public String getNegativeOccupationName() {
		return negativeOccupationName;
	}
	public void setNegativeOccupationName(String negativeOccupationName) {
		this.negativeOccupationName = negativeOccupationName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public List<NegativeOccupationInfo> getNegativeOccupationInfo() {
		return negativeOccupationInfo;
	}
	public void setNegativeOccupationInfo(List<NegativeOccupationInfo> negativeOccupationInfo) {
		this.negativeOccupationInfo = negativeOccupationInfo;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	public String getAssessedRisk() {
		return assessedRisk;
	}
	public void setAssessedRisk(String assessedRisk) {
		this.assessedRisk = assessedRisk;
	}
	@Override
	public String toString() {
		return "NegativeOccupation [negativeOccupationId=" + negativeOccupationId + ", negativeOccupationName="
				+ negativeOccupationName + ", area=" + area + ", negativeOccupationInfo=" + negativeOccupationInfo
				+ ", otherInformation=" + otherInformation + ", assessedRisk=" + assessedRisk + "]";
	}
	
	

	
}
