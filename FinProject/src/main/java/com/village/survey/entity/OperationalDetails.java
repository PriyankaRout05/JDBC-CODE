package com.village.survey.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operational_details")
public class OperationalDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9053358494421264564L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long clientDetail;
	private Float pos;
	private Float par;
	private Float amtPar;

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public Long getClientDetail() {
		return clientDetail;
	}

	public void setClientDetail(Long clientDetail) {
		this.clientDetail = clientDetail;
	}

	public Float getPos() {
		return pos;
	}

	public void setPos(Float pos) {
		this.pos = pos;
	}

	public Float getPar() {
		return par;
	}

	public void setPar(Float par) {
		this.par = par;
	}

	public Float getAmtPar() {
		return amtPar;
	}

	public void setAmtPar(Float amtPar) {
		this.amtPar = amtPar;
	}

	@Override
	public String toString() {
		return "OperationalDetails [id=" + id + ", clientDetail=" + clientDetail + ", pos=" + pos + ", par=" + par
				+ ", amtPar=" + amtPar + "]";
	}

}