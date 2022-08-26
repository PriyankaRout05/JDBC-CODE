package com.village.survey.entity;

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
@Table(name = "visited_institutions")
public class VisitedInstitutions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long visitedInstitutionsId;
	private String type;
	private String contactPerson;
	private long contactNumber;
	private Date operatigSince;
	@OneToMany(targetEntity = OperationalDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "visitedInstitutionsId")
	private List<OperationalDetails> operationalDetails;
	@OneToMany(targetEntity = MajorPARVillage.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "visitedInstitutionsId")
	private List<MajorPARVillage> majorPARVillages;
	@OneToMany(targetEntity = NegativeVillage.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "visitedInstitutionsId")
	private List<NegativeVillage> negativeVillages;

	public long getVisitedInstitutionsId() {
		return visitedInstitutionsId;
	}

	public void setVisitedInstitutionsId(long visitedInstitutionsId) {
		this.visitedInstitutionsId = visitedInstitutionsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getOperatigSince() {
		return operatigSince;
	}

	public void setOperatigSince(Date operatigSince) {
		this.operatigSince = operatigSince;
	}

	public List<OperationalDetails> getOperationalDetails() {
		return operationalDetails;
	}

	public void setOperationalDetails(List<OperationalDetails> operationalDetails) {
		this.operationalDetails = operationalDetails;
	}

	public List<MajorPARVillage> getMajorPARVillages() {
		return majorPARVillages;
	}

	public void setMajorPARVillages(List<MajorPARVillage> majorPARVillages) {
		this.majorPARVillages = majorPARVillages;
	}

	public List<NegativeVillage> getNegativeVillages() {
		return negativeVillages;
	}

	public void setNegativeVillages(List<NegativeVillage> negativeVillages) {
		this.negativeVillages = negativeVillages;
	}

	@Override
	public String toString() {
		return "VisitedInstitutions [visitedInstitutionsId=" + visitedInstitutionsId + ", type=" + type
				+ ", contactPerson=" + contactPerson + ", contactNumber=" + contactNumber + ", operatigSince="
				+ operatigSince + ", operationalDetails=" + operationalDetails + ", majorPARVillages="
				+ majorPARVillages + ", negativeVillages=" + negativeVillages + "]";
	}

}
