package com.mobios.ep.web.models;


public class ResponseDiagnosticReportedSymptomsWM {
	
	private int id;	
	private int responseDiagnosticId;
	private String symptomsReported;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResponseDiagnosticId() {
		return responseDiagnosticId;
	}
	public void setResponseDiagnosticId(int responseDiagnosticId) {
		this.responseDiagnosticId = responseDiagnosticId;
	}
	public String getSymptomsReported() {
		return symptomsReported;
	}
	public void setSymptomsReported(String symptomsReported) {
		this.symptomsReported = symptomsReported;
	}
}
