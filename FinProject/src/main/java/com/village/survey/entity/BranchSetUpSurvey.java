package com.village.survey.entity;

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
@Table(name = "branch_set_up_survey")
public class BranchSetUpSurvey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int surveyId;
	private String title;
	@OneToMany(targetEntity = ParticularRecords.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "particular_records_id", referencedColumnName = "surveyId")
	private List<ParticularRecords> particularRecords;

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ParticularRecords> getParticularRecords() {
		return particularRecords;
	}

	public void setParticularRecords(List<ParticularRecords> particularRecords) {
		this.particularRecords = particularRecords;
	}

	@Override
	public String toString() {
		return "BranchSetUpSurvey [surveyId=" + surveyId + ", title=" + title + ", particularRecords="
				+ particularRecords + "]";
	}

}
