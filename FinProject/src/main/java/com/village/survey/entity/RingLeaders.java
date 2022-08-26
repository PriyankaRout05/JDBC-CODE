package com.village.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ring_leaders")
public class RingLeaders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  ringLeadersId;
	private String ringLeader;
	private long identifier1;
	private  String identifier2;
	
	public long getRingLeadersId() {
		return ringLeadersId;
	}
	public void setRingLeadersId(long ringLeadersId) {
		this.ringLeadersId = ringLeadersId;
	}
	public String getRingLeader() {
		return ringLeader;
	}
	public void setRingLeader(String ringLeader) {
		this.ringLeader = ringLeader;
	}
	public long getIdentifier1() {
		return identifier1;
	}
	public void setIdentifier1(long identifier1) {
		this.identifier1 = identifier1;
	}
	public String getIdentifier2() {
		return identifier2;
	}
	public void setIdentifier2(String identifier2) {
		this.identifier2 = identifier2;
	}
	@Override
	public String toString() {
		return "RingLeaders [ringLeadersId=" + ringLeadersId + ", ringLeader=" + ringLeader + ", identifier1="
				+ identifier1 + ", identifier2=" + identifier2 + "]";
	}
	
	
	

}
