package com.village.survey.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "village_approval")
public class VillageApproval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long villageApprovalId;
	private String agenda;
	private Date date;
	private Time time;
	private List<String> addMembers;
	private String s3Url;

	private String newOrResubmit;
	private Long noOfResubmit;

	private String finalRating;
	private String riskRating;
	private String bmRating;
	private String amOrRisk;

	private String approve;
	private String reconsider;
	private String reject;
	private String reDoProjectionMeeting;
	private String amComments;

	public Long getVillageApprovalId() {
		return villageApprovalId;
	}

	public void setVillageApprovalId(Long villageApprovalId) {
		this.villageApprovalId = villageApprovalId;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<String> getAddMembers() {
		return addMembers;
	}

	public void setAddMembers(List<String> addMembers) {
		this.addMembers = addMembers;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}

	public String getNewOrResubmit() {
		return newOrResubmit;
	}

	public void setNewOrResubmit(String newOrResubmit) {
		this.newOrResubmit = newOrResubmit;
	}

	public Long getNoOfResubmit() {
		return noOfResubmit;
	}

	public void setNoOfResubmit(Long noOfResubmit) {
		this.noOfResubmit = noOfResubmit;
	}

	public String getFinalRating() {
		return finalRating;
	}

	public void setFinalRating(String finalRating) {
		this.finalRating = finalRating;
	}

	public String getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(String riskRating) {
		this.riskRating = riskRating;
	}

	public String getBmRating() {
		return bmRating;
	}

	public void setBmRating(String bmRating) {
		this.bmRating = bmRating;
	}

	public String getAmOrRisk() {
		return amOrRisk;
	}

	public void setAmOrRisk(String amOrRisk) {
		this.amOrRisk = amOrRisk;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getReconsider() {
		return reconsider;
	}

	public void setReconsider(String reconsider) {
		this.reconsider = reconsider;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public String getReDoProjectionMeeting() {
		return reDoProjectionMeeting;
	}

	public void setReDoProjectionMeeting(String reDoProjectionMeeting) {
		this.reDoProjectionMeeting = reDoProjectionMeeting;
	}

	public String getAmComments() {
		return amComments;
	}

	public void setAmComments(String amComments) {
		this.amComments = amComments;
	}

	@Override
	public String toString() {
		return "VillageApproval [villageApprovalId=" + villageApprovalId + ", agenda=" + agenda + ", date=" + date
				+ ", time=" + time + ", addMembers=" + addMembers + ", s3Url=" + s3Url + ", newOrResubmit="
				+ newOrResubmit + ", noOfResubmit=" + noOfResubmit + ", finalRating=" + finalRating + ", riskRating="
				+ riskRating + ", bmRating=" + bmRating + ", amOrRisk=" + amOrRisk + ", approve=" + approve
				+ ", reconsider=" + reconsider + ", reject=" + reject + ", reDoProjectionMeeting="
				+ reDoProjectionMeeting + ", amComments=" + amComments + "]";
	}

}
