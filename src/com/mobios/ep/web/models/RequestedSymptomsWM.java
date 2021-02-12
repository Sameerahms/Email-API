package com.mobios.ep.web.models;

public class RequestedSymptomsWM {
	
	private int id;	
	private int requestDiagnosticId;
	private String symptom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequestDiagnosticId() {
		return requestDiagnosticId;
	}
	public void setRequestDiagnosticId(int requestDiagnosticId) {
		this.requestDiagnosticId = requestDiagnosticId;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
}
