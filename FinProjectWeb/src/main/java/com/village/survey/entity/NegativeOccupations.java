package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "negative_occupations")
public class NegativeOccupations implements Serializable {

	private static final long serialVersionUID = 7207979729129785148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int negativeOccupationsId;

	private String otherInformation;

	private String assessedRisk;

	private Date createdOn;

	private Long createdUser;

	private Date modifiedOn;

	private Long modifiedUser;

	private int active;

	@OneToMany(targetEntity = NegativeOccupationsInformation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negative_occupation_id", referencedColumnName = "negativeOccupationsId")
	private List<NegativeOccupationsInformation> negativeOccupationsInformation;

	public int getNegativeOccupationsId() {
		return negativeOccupationsId;
	}

	public void setNegativeOccupationsId(int negativeOccupationsId) {
		this.negativeOccupationsId = negativeOccupationsId;
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

	public List<NegativeOccupationsInformation> getNegativeOccupationsInformation() {
		return negativeOccupationsInformation;
	}

	public void setNegativeOccupationsInformation(List<NegativeOccupationsInformation> negativeOccupationsInformation) {
		this.negativeOccupationsInformation = negativeOccupationsInformation;
	}

	@Override
	public String toString() {
		return "NegativeOccupations [negativeOccupationsId=" + negativeOccupationsId + ", otherInformation="
				+ otherInformation + ", assessedRisk=" + assessedRisk + ", createdOn=" + createdOn + ", createdUser="
				+ createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ ", negativeOccupationsInformation=" + negativeOccupationsInformation + "]";
	}

}
