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
@Table(name = "visited_institutions")
public class VisitedInstitutions implements Serializable {

	private static final long serialVersionUID = 3238166258233449442L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long visitedInstitutionsId;
	private Long type;
	private Long institutionName;
	private String contactPerson;
	private Long contactNumber;
	private String coordinates;
	private Date operatingSince;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	@OneToMany(targetEntity = OperationalDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "operational_details_information_id", referencedColumnName = "visitedInstitutionsId")
	private List<OperationalDetails> operationalDetails;

	@OneToMany(targetEntity = MajorPARVillages.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "major_par_villages_information_id", referencedColumnName = "visitedInstitutionsId")
	private List<MajorPARVillages> majorPARVillages;

	@OneToMany(targetEntity = NegativeVillages.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negative_villages_information_id", referencedColumnName = "visitedInstitutionsId")
	private List<NegativeVillages> negativeVillages;

	public Long getVisitedInstitutionsId() {
		return visitedInstitutionsId;
	}

	public void setVisitedInstitutionsId(Long visitedInstitutionsId) {
		this.visitedInstitutionsId = visitedInstitutionsId;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(Long institutionName) {
		this.institutionName = institutionName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Date getOperatingSince() {
		return operatingSince;
	}

	public void setOperatingSince(Date operatingSince) {
		this.operatingSince = operatingSince;
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

	public List<OperationalDetails> getOperationalDetails() {
		return operationalDetails;
	}

	public void setOperationalDetails(List<OperationalDetails> operationalDetails) {
		this.operationalDetails = operationalDetails;
	}

	public List<MajorPARVillages> getMajorPARVillages() {
		return majorPARVillages;
	}

	public void setMajorPARVillages(List<MajorPARVillages> majorPARVillages) {
		this.majorPARVillages = majorPARVillages;
	}

	public List<NegativeVillages> getNegativeVillages() {
		return negativeVillages;
	}

	public void setNegativeVillages(List<NegativeVillages> negativeVillages) {
		this.negativeVillages = negativeVillages;
	}

	@Override
	public String toString() {
		return "VisitedInstitutions [visitedInstitutionsId=" + visitedInstitutionsId + ", type=" + type
				+ ", institutionName=" + institutionName + ", contactPerson=" + contactPerson + ", contactNumber="
				+ contactNumber + ", coordinates=" + coordinates + ", operatingSince=" + operatingSince + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + ", operationalDetails=" + operationalDetails
				+ ", majorPARVillages=" + majorPARVillages + ", negativeVillages=" + negativeVillages + "]";
	}

}
