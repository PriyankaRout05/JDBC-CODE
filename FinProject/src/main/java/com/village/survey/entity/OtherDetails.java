package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "other_details")
public class OtherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otherId;
	private String contactPerson;
	private Long contactNumber;
	private int noOfHouseholds;
	private int noOfKiranaShops;
	private int noOfCosmeticShops;
	private int noOfSmallEatries;
	private int noOfOtherShops;
	private int noOfmilkCollCenter;
	
	public long getOtherId() {
		return otherId;
	}
	public void setOtherId(long otherId) {
		this.otherId = otherId;
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
	public int getNoOfHouseholds() {
		return noOfHouseholds;
	}
	public void setNoOfHouseholds(int noOfHouseholds) {
		this.noOfHouseholds = noOfHouseholds;
	}
	public int getNoOfKiranaShops() {
		return noOfKiranaShops;
	}
	public void setNoOfKiranaShops(int noOfKiranaShops) {
		this.noOfKiranaShops = noOfKiranaShops;
	}
	public int getNoOfCosmeticShops() {
		return noOfCosmeticShops;
	}
	public void setNoOfCosmeticShops(int noOfCosmeticShops) {
		this.noOfCosmeticShops = noOfCosmeticShops;
	}
	public int getNoOfSmallEatries() {
		return noOfSmallEatries;
	}
	public void setNoOfSmallEatries(int noOfSmallEatries) {
		this.noOfSmallEatries = noOfSmallEatries;
	}
	public int getNoOfOtherShops() {
		return noOfOtherShops;
	}
	public void setNoOfOtherShops(int noOfOtherShops) {
		this.noOfOtherShops = noOfOtherShops;
	}
	public int getNoOfmilkCollCenter() {
		return noOfmilkCollCenter;
	}
	public void setNoOfmilkCollCenter(int noOfmilkCollCenter) {
		this.noOfmilkCollCenter = noOfmilkCollCenter;
	}
	@Override
	public String toString() {
		return "OtherDetails [otherId=" + otherId + ", contactPerson=" + contactPerson + ", contactNumber="
				+ contactNumber + ", noOfHouseholds=" + noOfHouseholds + ", noOfKiranaShops=" + noOfKiranaShops
				+ ", noOfCosmeticShops=" + noOfCosmeticShops + ", noOfSmallEatries=" + noOfSmallEatries
				+ ", noOfOtherShops=" + noOfOtherShops + ", noOfmilkCollCenter=" + noOfmilkCollCenter + "]";
	}
	
	
	
	
	
}
