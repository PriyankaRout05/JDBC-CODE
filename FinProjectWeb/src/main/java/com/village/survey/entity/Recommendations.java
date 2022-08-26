package com.village.survey.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recommendations")
public class Recommendations implements Serializable {

	private static final long serialVersionUID = -189107545604087962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recommendationsId;

	private String option1;

	private Long block1;

	private String option2;

	private Long block2;

	private String finalRecommendations;

	private String finalRecommendationsBySurveyor;

	private String finalRecommendationsByRm;

	private Date createdOn;

	private Long createdUser;

	private Date modifiedOn;

	private Long modifiedUser;

	private int active;

	@OneToMany(targetEntity = KeyFindings.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "key_findings_information_id", referencedColumnName = "recommendationsId")
	private List<KeyFindings> keyFindings;

	public Long getRecommendationsId() {
		return recommendationsId;
	}

	public void setRecommendationsId(Long recommendationsId) {
		this.recommendationsId = recommendationsId;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public Long getBlock1() {
		return block1;
	}

	public void setBlock1(Long block1) {
		this.block1 = block1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public Long getBlock2() {
		return block2;
	}

	public void setBlock2(Long block2) {
		this.block2 = block2;
	}

	public String getFinalRecommendations() {
		return finalRecommendations;
	}

	public void setFinalRecommendations(String finalRecommendations) {
		this.finalRecommendations = finalRecommendations;
	}

	public String getFinalRecommendationsBySurveyor() {
		return finalRecommendationsBySurveyor;
	}

	public void setFinalRecommendationsBySurveyor(String finalRecommendationsBySurveyor) {
		this.finalRecommendationsBySurveyor = finalRecommendationsBySurveyor;
	}

	public String getFinalRecommendationsByRm() {
		return finalRecommendationsByRm;
	}

	public void setFinalRecommendationsByRm(String finalRecommendationsByRm) {
		this.finalRecommendationsByRm = finalRecommendationsByRm;
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

	public List<KeyFindings> getKeyFindings() {
		return keyFindings;
	}

	public void setKeyFindings(List<KeyFindings> keyFindings) {
		this.keyFindings = keyFindings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Recommendations [recommendationsId=" + recommendationsId + ", option1=" + option1 + ", block1=" + block1
				+ ", option2=" + option2 + ", block2=" + block2 + ", finalRecommendations=" + finalRecommendations
				+ ", finalRecommendationsBySurveyor=" + finalRecommendationsBySurveyor + ", finalRecommendationsByRm="
				+ finalRecommendationsByRm + ", createdOn=" + createdOn + ", createdUser=" + createdUser
				+ ", modifiedOn=" + modifiedOn + ", modifiedUser=" + modifiedUser + ", active=" + active
				+ ", keyFindings=" + keyFindings + "]";
	}

}
