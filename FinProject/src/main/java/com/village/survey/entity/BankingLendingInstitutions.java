package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banking_lending_institutions")
public class BankingLendingInstitutions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankinglendingId;
	private String name;
	private String type;
	private long clients;

	public long getbankinglendingId() {
		return bankinglendingId;
	}

	public void setbankinglendingId(long bankinglendingId) {
		this.bankinglendingId = bankinglendingId;
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

	public long getClients() {
		return clients;
	}

	public void setClients(long clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "BankingLendingInstitutions [bankinglendingId=" + bankinglendingId + ", name=" + name + ", type=" + type
				+ ", clients=" + clients + "]";
	}

}
