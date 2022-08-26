package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "major_par_villages")
public class MajorPARVillages implements Serializable {

	private static final long serialVersionUID = 4697304886476109142L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long majorParVillagesId;
	private String name;
	private Long clients;
	private String reasons;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getMajorParVillagesId() {
		return majorParVillagesId;
	}

	public void setMajorParVillagesId(Long majorParVillagesId) {
		this.majorParVillagesId = majorParVillagesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getClients() {
		return clients;
	}

	public void setClients(Long clients) {
		this.clients = clients;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
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
		return "MajorPARVillages [majorParVillagesId=" + majorParVillagesId + ", name=" + name + ", clients=" + clients
				+ ", reasons=" + reasons + ", createdOn=" + createdOn + ", createdUser=" + createdUser + ", modifiedOn="
				+ modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active + "]";
	}

}
