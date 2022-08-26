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
@Table(name = "financial_info")
public class FinancialInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private String contactPerson;
	private Long contactNumber;
	private String address;
	private Date operatingSince;
	@OneToMany(targetEntity = OperationalDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "operational_details", referencedColumnName = "id")
	private List<OperationalDetails> operationalDetails;
	@OneToMany(targetEntity = MajorPARVillage.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "major_par_village", referencedColumnName = "id")
	private List<MajorPARVillage> majorPARVillage;
	@OneToMany(targetEntity = NegativeVillage.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "negative_village", referencedColumnName = "id")
	private List<NegativeVillage> negativeVillage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOperatingSince() {
		return operatingSince;
	}

	public void setOperatingSince(Date operatingSince) {
		this.operatingSince = operatingSince;
	}

	public List<OperationalDetails> getOperationalDetails() {
		return operationalDetails;
	}

	public void setOperationalDetails(List<OperationalDetails> operationalDetails) {
		this.operationalDetails = operationalDetails;
	}

	public List<MajorPARVillage> getMajorPARVillage() {
		return majorPARVillage;
	}

	public void setMajorPARVillage(List<MajorPARVillage> majorPARVillage) {
		this.majorPARVillage = majorPARVillage;
	}

	public List<NegativeVillage> getNegativeVillage() {
		return negativeVillage;
	}

	public void setNegativeVillage(List<NegativeVillage> negativeVillage) {
		this.negativeVillage = negativeVillage;
	}

	@Override
	public String toString() {
		return "FinancialInfo [id=" + id + ", name=" + name + ", type=" + type + ", contactPerson=" + contactPerson
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", operatingSince=" + operatingSince
				+ ", operationalDetails=" + operationalDetails + ", majorPARVillage=" + majorPARVillage
				+ ", negativeVillage=" + negativeVillage + "]";
	}

}
