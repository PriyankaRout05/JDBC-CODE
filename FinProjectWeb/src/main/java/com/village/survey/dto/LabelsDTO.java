package com.village.survey.dto;

import java.io.Serializable;

public class LabelsDTO implements Serializable {
	private static final long serialVersionUID = -2615389872135412156L;
	private String labelName;
	private AuthorityDTO authority;

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

}
