package com.priyanka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class EmployeeModel {
	@Id
	@GeneratedValue
	
	private int id;
	private long  salary;
	private String first_name;
	private String last_name;
	

}
