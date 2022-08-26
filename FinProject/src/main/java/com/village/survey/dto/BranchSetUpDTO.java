package com.village.survey.dto;

import com.village.survey.entity.BranchSetUp;

public class BranchSetUpDTO {
	
	private BranchSetUp branchSetUp;

	public BranchSetUp getBranchSetUp() {
		return branchSetUp;
	}

	public void setBranchSetUp(BranchSetUp branchSetUp) {
		this.branchSetUp = branchSetUp;
	}

	@Override
	public String toString() {
		return "BranchSetUpDTO [branchSetUp=" + branchSetUp + "]";
	}
	

}
