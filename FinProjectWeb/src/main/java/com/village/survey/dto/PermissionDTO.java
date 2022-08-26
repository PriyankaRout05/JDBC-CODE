package com.village.survey.dto;

import java.io.Serializable;
import java.util.List;

public class PermissionDTO implements Serializable {
	private static final long serialVersionUID = -7621998852494005908L;
	private List<TabNameDTO> tabNameList;

	public List<TabNameDTO> getTabNameList() {
		return tabNameList;
	}

	public void setTabNameList(List<TabNameDTO> tabNameList) {
		this.tabNameList = tabNameList;
	}

}
