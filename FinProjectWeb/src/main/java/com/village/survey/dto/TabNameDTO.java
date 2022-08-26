package com.village.survey.dto;

import java.io.Serializable;
import java.util.List;

public class TabNameDTO implements Serializable {

	private static final long serialVersionUID = -3647531975616376361L;
	private String tabName;
	private AuthorityDTO authority;
	private List<GroupNameDTO> groupNameList;

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

	public List<GroupNameDTO> getGroupNameList() {
		return groupNameList;
	}

	public void setGroupNameList(List<GroupNameDTO> groupNameList) {
		this.groupNameList = groupNameList;
	}

}
