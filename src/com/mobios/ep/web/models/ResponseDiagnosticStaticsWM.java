package com.mobios.ep.web.models;

import java.util.List;

import javax.persistence.Column;

public class ResponseDiagnosticStaticsWM {

	private int id;	

	private int responseDiagnosticId;

	private String disease;
	
	private int symptomsComplained;
	
	private List<ResponseDiagnosticStaticsComplainedSymptomsWM> responseDiagnosticStaticsComplainedSymptomsWMs;

	private int symptomsNotComplained;
	
	private List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> responseDiagnosticStaticsNotComplainedSymptomsWMs;

	private int symptomsUnexplained;
	
	private List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> responseDiagnosticStaticsUnexplainedSymptomsWMs;

	private float explanatoryProbabiliy;
	
	private float contributoryProbability;
	
	private float ruleOutProbability;
	
	private float comorbidityProbability;
	
	
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	

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

	public int getSymptomsComplained() {
		return symptomsComplained;
	}

	public void setSymptomsComplained(int symptomsComplained) {
		this.symptomsComplained = symptomsComplained;
	}

	public int getSymptomsNotComplained() {
		return symptomsNotComplained;
	}

	public void setSymptomsNotComplained(int symptomsNotComplained) {
		this.symptomsNotComplained = symptomsNotComplained;
	}

	public int getSymptomsUnexplained() {
		return symptomsUnexplained;
	}

	public void setSymptomsUnexplained(int symptomsUnexplained) {
		this.symptomsUnexplained = symptomsUnexplained;
	}

	public float getExplanatoryProbabiliy() {
		return explanatoryProbabiliy;
	}

	public void setExplanatoryProbabiliy(float explanatoryProbabiliy) {
		this.explanatoryProbabiliy = explanatoryProbabiliy;
	}

	public float getContributoryProbability() {
		return contributoryProbability;
	}

	public void setContributoryProbability(float contributoryProbability) {
		this.contributoryProbability = contributoryProbability;
	}

	public float getRuleOutProbability() {
		return ruleOutProbability;
	}

	public void setRuleOutProbability(float ruleOutProbability) {
		this.ruleOutProbability = ruleOutProbability;
	}

	public float getComorbidityProbability() {
		return comorbidityProbability;
	}

	public void setComorbidityProbability(float comorbidityProbability) {
		this.comorbidityProbability = comorbidityProbability;
	}

	public List<ResponseDiagnosticStaticsComplainedSymptomsWM> getResponseDiagnosticStaticsComplainedSymptomsWMs() {
		return responseDiagnosticStaticsComplainedSymptomsWMs;
	}

	public void setResponseDiagnosticStaticsComplainedSymptomsWMs(
			List<ResponseDiagnosticStaticsComplainedSymptomsWM> responseDiagnosticStaticsComplainedSymptomsWMs) {
		this.responseDiagnosticStaticsComplainedSymptomsWMs = responseDiagnosticStaticsComplainedSymptomsWMs;
	}

	public List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> getResponseDiagnosticStaticsNotComplainedSymptomsWMs() {
		return responseDiagnosticStaticsNotComplainedSymptomsWMs;
	}

	public void setResponseDiagnosticStaticsNotComplainedSymptomsWMs(
			List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> responseDiagnosticStaticsNotComplainedSymptomsWMs) {
		this.responseDiagnosticStaticsNotComplainedSymptomsWMs = responseDiagnosticStaticsNotComplainedSymptomsWMs;
	}

	public List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> getResponseDiagnosticStaticsUnexplainedSymptomsWMs() {
		return responseDiagnosticStaticsUnexplainedSymptomsWMs;
	}

	public void setResponseDiagnosticStaticsUnexplainedSymptomsWMs(
			List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> responseDiagnosticStaticsUnexplainedSymptomsWMs) {
		this.responseDiagnosticStaticsUnexplainedSymptomsWMs = responseDiagnosticStaticsUnexplainedSymptomsWMs;
	}
	
	
	
	
}
