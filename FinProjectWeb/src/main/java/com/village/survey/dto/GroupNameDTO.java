package com.village.survey.dto;

import java.io.Serializable;
import java.util.List;

public class GroupNameDTO implements Serializable {
	private static final long serialVersionUID = -3610483460422031608L;
	private String groupName;
	private AuthorityDTO authority;
	private List<LabelsDTO> labels;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

	public List<LabelsDTO> getLabels() {
		return labels;
	}

	public void setLabels(List<LabelsDTO> labels) {
		this.labels = labels;
	}

}
