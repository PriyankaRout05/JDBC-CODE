package com.village.survey.dto;

import java.io.Serializable;
import java.util.List;

public class RolePermisionDTO implements Serializable {

	private static final long serialVersionUID = -2952633422385455032L;
	private Long roleId;
	private String roleName;
	private List<String> permissions;

	public RolePermisionDTO() {

	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

}
