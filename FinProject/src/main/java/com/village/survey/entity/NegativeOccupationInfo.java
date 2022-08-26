package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negativeoccupation_info")
public class NegativeOccupationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long negativeOccupationInfoId;
	private String otherInformation;
	private String assessedRisk;
			
	public long getNegativeOccupationInfoId() {
		return negativeOccupationInfoId;
	}

	public void setNegativeOccupationInfoId(long negativeOccupationInfoId) {
		this.negativeOccupationInfoId = negativeOccupationInfoId;
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
		return "NegativeOccupationInfo [negativeOccupationInfoId=" + negativeOccupationInfoId + ", otherInformation="
				+ otherInformation + ", assessedRisk=" + assessedRisk + "]";
	}

}
