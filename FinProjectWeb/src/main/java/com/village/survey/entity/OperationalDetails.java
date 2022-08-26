package com.village.survey.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operational_details")
public class OperationalDetails implements Serializable {

	private static final long serialVersionUID = -9053358494421264564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long operationalDetailsId;
	private Long clientDetail;
	private BigDecimal pos;
	private BigDecimal par;
	private BigDecimal amtPar;
	private Date createdOn;
	private Long createdUser;
	private Date modifiedOn;
	private Long modifiedUser;
	private int active;

	public Long getOperationalDetailsId() {
		return operationalDetailsId;
	}

	public void setOperationalDetailsId(Long operationalDetailsId) {
		this.operationalDetailsId = operationalDetailsId;
	}

	public Long getClientDetail() {
		return clientDetail;
	}

	public void setClientDetail(Long clientDetail) {
		this.clientDetail = clientDetail;
	}

	public BigDecimal getPos() {
		return pos;
	}

	public void setPos(BigDecimal pos) {
		this.pos = pos;
	}

	public BigDecimal getPar() {
		return par;
	}

	public void setPar(BigDecimal par) {
		this.par = par;
	}

	public BigDecimal getAmtPar() {
		return amtPar;
	}

	public void setAmtPar(BigDecimal amtPar) {
		this.amtPar = amtPar;
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
		return "OperationalDetails [operationalDetailsId=" + operationalDetailsId + ", clientDetail=" + clientDetail
				+ ", pos=" + pos + ", par=" + par + ", amtPar=" + amtPar + ", createdOn=" + createdOn + ", createdUser="
				+ createdUser + ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ "]";
	}

}