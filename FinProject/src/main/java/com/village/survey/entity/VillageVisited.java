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
@Table(name = "village_visited")

public class VillageVisited {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long visitedId;
	private String suitableForPragatiOperations;
	private int numberOfClients;
	@OneToMany(targetEntity = EconomicAndFinancialInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "economicfinancial_id", referencedColumnName = "visitedId")
	private List<EconomicAndFinancialInfo> economicAndFinancialInfo;

	@OneToMany(targetEntity =OtherDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name="otherdetails_id",referencedColumnName = "visitedId")
	private List<OtherDetails> otherDetails;

	@OneToMany(targetEntity = Activity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "activity", referencedColumnName = "visitedId")
	private List<Activity> activity;

	@OneToMany(targetEntity = BankingLendingInstitutions.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bankinglending_institutions_id", referencedColumnName = "visitedId")
	private List<BankingLendingInstitutions> bankingLendingInstitutions;

	public long getVisitedId() {
		return visitedId;
	}

	public void setVisitedId(long visitedId) {
		this.visitedId = visitedId;
	}

	public String getSuitableForPragatiOperations() {
		return suitableForPragatiOperations;
	}

	public void setSuitableForPragatiOperations(String suitableForPragatiOperations) {
		this.suitableForPragatiOperations = suitableForPragatiOperations;
	}

	public int getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(int numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public List<EconomicAndFinancialInfo> getEconomicAndFinancialInfo() {
		return economicAndFinancialInfo;
	}

	public void setEconomicAndFinancialInfo(List<EconomicAndFinancialInfo> economicAndFinancialInfo) {
		this.economicAndFinancialInfo = economicAndFinancialInfo;
	}

	public List<OtherDetails> getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(List<OtherDetails> otherDetails) {
		this.otherDetails = otherDetails;
	}

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	public List<BankingLendingInstitutions> getBankingLendingInstitutions() {
		return bankingLendingInstitutions;
	}

	public void setBankingLendingInstitutions(List<BankingLendingInstitutions> bankingLendingInstitutions) {
		this.bankingLendingInstitutions = bankingLendingInstitutions;
	}

	@Override
	public String toString() {
		return "VillageVisited [visitedId=" + visitedId + ", suitableForPragatiOperations="
				+ suitableForPragatiOperations + ", numberOfClients=" + numberOfClients + ", economicAndFinancialInfo="
				+ economicAndFinancialInfo + ", otherDetails=" + otherDetails + ", activity=" + activity
				+ ", bankingLendingInstitutions=" + bankingLendingInstitutions + "]";
	}



	
}
