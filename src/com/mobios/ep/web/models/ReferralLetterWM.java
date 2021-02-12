package com.mobios.ep.web.models;


public class ReferralLetterWM {
	
	private int id;
	private int doctorId;
	private int patientId;
	private int instituteId;
	private String referringDoctor;
	private String message;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getReferringDoctor() {
		return referringDoctor;
	}
	public void setReferringDoctor(String referringDoctor) {
		this.referringDoctor = referringDoctor;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
