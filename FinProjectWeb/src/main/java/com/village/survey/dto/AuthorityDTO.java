package com.village.survey.dto;

import java.io.Serializable;

public class AuthorityDTO implements Serializable {
	private static final long serialVersionUID = -6276434903132436081L;
	private Long permissionId;
	private String permissionDisplayName;
	private String permissionName;
	private String permissionType;
	private String tabName;
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getPermissionDisplayName() {
		return permissionDisplayName;
	}

	public void setPermissionDisplayName(String permissionDisplayName) {
		this.permissionDisplayName = permissionDisplayName;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}
