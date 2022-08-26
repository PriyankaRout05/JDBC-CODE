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
@Table(name="particular_records")
public class ParticularRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prId;
	private String particular;
	@OneToMany(targetEntity = Records.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "records_id", referencedColumnName = "prId")
	private List<Records> records;

	public int getPrId() {
		return prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "ParticularRecords [prId=" + prId + ", particular=" + particular + ", records=" + records + "]";
	}

}
