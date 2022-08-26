package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rent_and_deposites")
public class RentAndDeposites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rentAndDepositesId;
	private double rentAmountINR;
	private double advancesOrDeposits;
	private String comment;

	public Long getRentAndDepositesId() {
		return rentAndDepositesId;
	}

	public void setRentAndDepositesId(Long rentAndDepositesId) {
		this.rentAndDepositesId = rentAndDepositesId;
	}

	public double getRentAmountINR() {
		return rentAmountINR;
	}

	public void setRentAmountINR(double rentAmountINR) {
		this.rentAmountINR = rentAmountINR;
	}

	public double getAdvancesOrDeposits() {
		return advancesOrDeposits;
	}

	public void setAdvancesOrDeposits(double advancesOrDeposits) {
		this.advancesOrDeposits = advancesOrDeposits;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "RentAndDeposites [rentAndDepositesId=" + rentAndDepositesId + ", rentAmountINR=" + rentAmountINR
				+ ", advancesOrDeposits=" + advancesOrDeposits + ", comment=" + comment + "]";
	}

}
