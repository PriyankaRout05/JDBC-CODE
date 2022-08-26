package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner_information")
public class OwnerInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerInformationId;
	private String ownersName;
	private Long contactNumber;
	private String occupation;
	private String previousOccupant;
	private String comment;

	public Long getOwnerInformationId() {
		return ownerInformationId;
	}

	public void setOwnerInformationId(Long ownerInformationId) {
		this.ownerInformationId = ownerInformationId;
	}

	public String getOwnersName() {
		return ownersName;
	}

	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPreviousOccupant() {
		return previousOccupant;
	}

	public void setPreviousOccupant(String previousOccupant) {
		this.previousOccupant = previousOccupant;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "OwnerInformation [ownerInformationId=" + ownerInformationId + ", ownersName=" + ownersName
				+ ", contactNumber=" + contactNumber + ", occupation=" + occupation + ", previousOccupant="
				+ previousOccupant + ", comment=" + comment + "]";
	}

}
