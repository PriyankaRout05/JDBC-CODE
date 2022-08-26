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
@Table(name = "visited_villages")
public class VisitedVillages implements Serializable {

	private static final long serialVersionUID = 4223038127564913857L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long visitedVillagesId;
	private Long villageId;
	private Long districtId;
	private Long blockId;
	private Long pincode;
	private String coordinates;
	private Date presentTime;
	private String contactPerson;
	private Long contactNumber;
	private Long numberOfHouseholds;
	private Long numberOfMilkCenters;
	private Long numberOfKiranaShops;
	private Long numberOfCosmeticsShops;
	private Long numberOfOtherShops;
	private Long numberOfTeaeastries;
	private Long primaryActivity;
	private Long secondaryActivity;
	private String otherActivity;
	private Long question;
	private String value;
	private Long numberOfClients;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	@OneToMany(targetEntity = BankAndLendingInstitutions.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_and_lending_institutions_information_id", referencedColumnName = "visitedVillagesId")
	private List<BankAndLendingInstitutions> bankAndLendingInstitutions;

	public Long getVisitedVillagesId() {
		return visitedVillagesId;
	}

	public void setVisitedVillagesId(Long visitedVillagesId) {
		this.visitedVillagesId = visitedVillagesId;
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getBlockId() {
		return blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Date getPresentTime() {
		return presentTime;
	}

	public void setPresentTime(Date presentTime) {
		this.presentTime = presentTime;
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

	public Long getNumberOfHouseholds() {
		return numberOfHouseholds;
	}

	public void setNumberOfHouseholds(Long numberOfHouseholds) {
		this.numberOfHouseholds = numberOfHouseholds;
	}

	public Long getNumberOfMilkCenters() {
		return numberOfMilkCenters;
	}

	public void setNumberOfMilkCenters(Long numberOfMilkCenters) {
		this.numberOfMilkCenters = numberOfMilkCenters;
	}

	public Long getNumberOfKiranaShops() {
		return numberOfKiranaShops;
	}

	public void setNumberOfKiranaShops(Long numberOfKiranaShops) {
		this.numberOfKiranaShops = numberOfKiranaShops;
	}

	public Long getNumberOfCosmeticsShops() {
		return numberOfCosmeticsShops;
	}

	public void setNumberOfCosmeticsShops(Long numberOfCosmeticsShops) {
		this.numberOfCosmeticsShops = numberOfCosmeticsShops;
	}

	public Long getNumberOfOtherShops() {
		return numberOfOtherShops;
	}

	public void setNumberOfOtherShops(Long numberOfOtherShops) {
		this.numberOfOtherShops = numberOfOtherShops;
	}

	public Long getNumberOfTeaeastries() {
		return numberOfTeaeastries;
	}

	public void setNumberOfTeaeastries(Long numberOfTeaeastries) {
		this.numberOfTeaeastries = numberOfTeaeastries;
	}

	public Long getPrimaryActivity() {
		return primaryActivity;
	}

	public void setPrimaryActivity(Long primaryActivity) {
		this.primaryActivity = primaryActivity;
	}

	public Long getSecondaryActivity() {
		return secondaryActivity;
	}

	public void setSecondaryActivity(Long secondaryActivity) {
		this.secondaryActivity = secondaryActivity;
	}

	public String getOtherActivity() {
		return otherActivity;
	}

	public void setOtherActivity(String otherActivity) {
		this.otherActivity = otherActivity;
	}

	public Long getQuestion() {
		return question;
	}

	public void setQuestion(Long question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(Long numberOfClients) {
		this.numberOfClients = numberOfClients;
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

	public List<BankAndLendingInstitutions> getBankAndLendingInstitutions() {
		return bankAndLendingInstitutions;
	}

	public void setBankAndLendingInstitutions(List<BankAndLendingInstitutions> bankAndLendingInstitutions) {
		this.bankAndLendingInstitutions = bankAndLendingInstitutions;
	}

	@Override
	public String toString() {
		return "VisitedVillages [visitedVillagesId=" + visitedVillagesId + ", villageId=" + villageId + ", districtId="
				+ districtId + ", blockId=" + blockId + ", pincode=" + pincode + ", coordinates=" + coordinates
				+ ", presentTime=" + presentTime + ", contactPerson=" + contactPerson + ", contactNumber="
				+ contactNumber + ", numberOfHouseholds=" + numberOfHouseholds + ", numberOfMilkCenters="
				+ numberOfMilkCenters + ", numberOfKiranaShops=" + numberOfKiranaShops + ", numberOfCosmeticsShops="
				+ numberOfCosmeticsShops + ", numberOfOtherShops=" + numberOfOtherShops + ", numberOfTeaeastries="
				+ numberOfTeaeastries + ", primaryActivity=" + primaryActivity + ", secondaryActivity="
				+ secondaryActivity + ", otherActivity=" + otherActivity + ", question=" + question + ", value=" + value
				+ ", numberOfClients=" + numberOfClients + ", createdOn=" + createdOn + ", createdUser=" + createdUser
				+ ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ ", bankAndLendingInstitutions=" + bankAndLendingInstitutions + "]";
	}

}
