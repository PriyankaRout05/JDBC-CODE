package com.SbSecurity;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public class Student {
	private final Integer studentId;
	private final String studentName;
	
	public Student(Integer studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	  @Override
	    public String toString() {
	        return "Student{" +
	                "studentId=" + studentId +
	                ", studentName='" + studentName + '\'' +
	                '}';
	
	  }

	public static String name() {
		// TODO Auto-generated method stub
		return name();
	}

	public static Set<? extends GrantedAuthority> getGrantedAuthorities() {
		// TODO Auto-generated method stub
		return getGrantedAuthorities();
	}
}
	



	

