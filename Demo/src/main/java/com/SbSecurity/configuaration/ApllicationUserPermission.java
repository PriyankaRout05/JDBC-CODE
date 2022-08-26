package com.SbSecurity.configuaration;

public enum ApllicationUserPermission {
	SRUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	 
	private ApllicationUserPermission(String permission) {
		this.permission = permission;
	}


	public String getPermission() {
		return permission;
	}

}
