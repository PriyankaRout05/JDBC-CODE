package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_and_lending_institutions")
public class BankAndLendingInstitutions implements Serializable {

	private static final long serialVersionUID = 759967933024065112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankAndLendingInstitutionsId;
	private String bankName;
	private String type;
	private int bankClients;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getBankAndLendingInstitutionsId() {
		return bankAndLendingInstitutionsId;
	}

	public void setBankAndLendingInstitutionsId(Long bankAndLendingInstitutionsId) {
		this.bankAndLendingInstitutionsId = bankAndLendingInstitutionsId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBankClients() {
		return bankClients;
	}

	public void setBankClients(int bankClients) {
		this.bankClients = bankClients;
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

	@Override
	public String toString() {
		return "BankAndLendingInstitutions [bankAndLendingInstitutionsId=" + bankAndLendingInstitutionsId
				+ ", bankName=" + bankName + ", type=" + type + ", bankClients=" + bankClients + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + "]";
	}

}
