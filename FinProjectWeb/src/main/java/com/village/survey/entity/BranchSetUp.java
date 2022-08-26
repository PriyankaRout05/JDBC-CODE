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
@Table(name = "branch_set_up")

public class BranchSetUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long branchSetUpId;

	@OneToMany(targetEntity = ResourcePersonDetalis.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "resource_person_detalis_id", referencedColumnName = "branchSetUpId")
	private List<ResourcePersonDetalis> resourcePersonDetalis;

	@OneToMany(targetEntity = BranchSetUpSurvey.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_set_up_survey_id", referencedColumnName = "branchSetUpId")
	private List<BranchSetUpSurvey> branchSetUpSurvey;

	public long getBranchSetUpId() {
		return branchSetUpId;
	}

	public void setBranchSetUpId(long branchSetUpId) {
		this.branchSetUpId = branchSetUpId;
	}

	public List<ResourcePersonDetalis> getResourcePersonDetalis() {
		return resourcePersonDetalis;
	}

	public void setResourcePersonDetalis(List<ResourcePersonDetalis> resourcePersonDetalis) {
		this.resourcePersonDetalis = resourcePersonDetalis;
	}

	public List<BranchSetUpSurvey> getBranchSetUpSurvey() {
		return branchSetUpSurvey;
	}

	public void setBranchSetUpSurvey(List<BranchSetUpSurvey> branchSetUpSurvey) {
		this.branchSetUpSurvey = branchSetUpSurvey;
	}

	@Override
	public String toString() {
		return "BranchSetUp [branchSetUpId=" + branchSetUpId + ", resourcePersonDetalis=" + resourcePersonDetalis
				+ ", branchSetUpSurvey=" + branchSetUpSurvey + "]";
	}

}
