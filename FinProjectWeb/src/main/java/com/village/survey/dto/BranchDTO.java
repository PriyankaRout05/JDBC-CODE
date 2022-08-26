package com.village.survey.dto;

public class BranchDTO {
	private Long branchId;
	private String branchName;
	private MandalDTO mandal;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public MandalDTO getMandal() {
		return mandal;
	}

	public void setMandal(MandalDTO mandal) {
		this.mandal = mandal;
	}

}
