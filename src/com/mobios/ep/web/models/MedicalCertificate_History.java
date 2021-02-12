package com.mobios.ep.web.models;

import javax.persistence.Column;

public class MedicalCertificate_History {

	private int id;
	private int medicalcertificateId;
	private String medicalcertificate;
	private String createdDate;
	private String userCreated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMedicalcertificateId() {
		return medicalcertificateId;
	}
	public void setMedicalcertificateId(int medicalcertificateId) {
		this.medicalcertificateId = medicalcertificateId;
	}
	public String getMedicalcertificate() {
		return medicalcertificate;
	}
	public void setMedicalcertificate(String medicalcertificate) {
		this.medicalcertificate = medicalcertificate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	
	
}
