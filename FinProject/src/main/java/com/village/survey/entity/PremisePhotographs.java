package com.village.survey.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "premise_photographs")
public class PremisePhotographs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long premisePhotographsId;

	@Lob
	@Column(name = "capture_internal_photographs", length = Integer.MAX_VALUE, nullable = true)
	private byte[] captureInternalPhotographs;

	@Lob
	@Column(name = "capture_external_photographs", length = Integer.MAX_VALUE, nullable = true)
	private byte[] captureExternalPhotographs;

	
	public Long getPremisePhotographsId() {
		return premisePhotographsId;
	}

	public void setPremisePhotographsId(Long premisePhotographsId) {
		this.premisePhotographsId = premisePhotographsId;
	}

	public byte[] getCaptureInternalPhotographs() {
		return captureInternalPhotographs;
	}

	public void setCaptureInternalPhotographs(byte[] captureInternalPhotographs) {
		this.captureInternalPhotographs = captureInternalPhotographs;
	}

	public byte[] getCaptureExternalPhotographs() {
		return captureExternalPhotographs;
	}

	public void setCaptureExternalPhotographs(byte[] captureExternalPhotographs) {
		this.captureExternalPhotographs = captureExternalPhotographs;
	}

	@Override
	public String toString() {
		return "PremisePhotographs [premisePhotographsId=" + premisePhotographsId + ", captureInternalPhotographs="
				+ Arrays.toString(captureInternalPhotographs) + ", captureExternalPhotographs="
				+ Arrays.toString(captureExternalPhotographs) + "]";
	}

}
