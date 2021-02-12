package com.mobios.ep.web.models;


public class ResponseDiagnosticStaticsComplainedSymptomsWM {

	private int id;	

	private int responseDiagnosticStaticsId;

	private String complainedSymptoms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResponseDiagnosticStaticsId() {
		return responseDiagnosticStaticsId;
	}

	public void setResponseDiagnosticStaticsId(int responseDiagnosticStaticsId) {
		this.responseDiagnosticStaticsId = responseDiagnosticStaticsId;
	}

	public String getComplainedSymptoms() {
		return complainedSymptoms;
	}

	public void setComplainedSymptoms(String complainedSymptoms) {
		this.complainedSymptoms = complainedSymptoms;
	}
}
