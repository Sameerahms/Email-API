package com.mobios.ep.web.models;

import java.util.List;

/**
 * Web model for medical stats
 * @author hasithakaushan
 *
 */
public class MedicalStatWM {
	
	private int id;
	private int patientId;
	private String drugAllergies;
	private String foodAllergies;
	private List<PastDiseases> pastDiseases;
	private String pastSurgeries;
	private String gynoObstetrics;
	private String investigations;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDrugAllergies() {
		return drugAllergies;
	}
	public void setDrugAllergies(String drugAllergies) {
		this.drugAllergies = drugAllergies;
	}
	public String getFoodAllergies() {
		return foodAllergies;
	}
	public void setFoodAllergies(String foodAllergies) {
		this.foodAllergies = foodAllergies;
	}
	public List<PastDiseases> getPastDiseases() {
		return pastDiseases;
	}
	public void setPastDiseases(List<PastDiseases> pastDiseases) {
		this.pastDiseases = pastDiseases;
	}
	public String getPastSurgeries() {
		return pastSurgeries;
	}
	public void setPastSurgeries(String pastSurgeries) {
		this.pastSurgeries = pastSurgeries;
	}
	public String getGynoObstetrics() {
		return gynoObstetrics;
	}
	public void setGynoObstetrics(String gynoObstetrics) {
		this.gynoObstetrics = gynoObstetrics;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	
}
