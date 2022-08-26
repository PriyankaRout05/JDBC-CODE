package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author vamsir
 *
 */
public class BranchVillages implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long village;
	private Long branch;
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

	public Long getVillage() {
		return village;
	}

	public void setVillage(Long village) {
		this.village = village;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
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

	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BranchVillages [id=" + id + ", village=" + village + ", branch=" + branch + ", createdOn=" + createdOn
				+ ", createdUser=" + createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser
				+ ", active=" + active + "]";
	}

}
