package com.mobios.ep.web.models;


public class ResponseDifferentialDiagnosisByExpanatoryProbabilityWM {

	private int id;	

	private int responseDiagnosticId;

	private String disease;

	private float probability;

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

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public float getProbability() {
		return probability;
	}

	public void setProbability(float probability) {
		this.probability = probability;
	}
}
