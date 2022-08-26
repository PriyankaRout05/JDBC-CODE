package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

public class Survey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8585502984799117943L;

	private Long id;
	private String name;
	private Long village;
	private String status;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVillage() {
		return village;
	}

	public void setVillage(Long village) {
		this.village = village;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", name=" + name + ", village=" + village + ", status=" + status + ", createdOn="
				+ createdOn + ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser="
				+ modifiedUser + ", active=" + active + "]";
	}

}
