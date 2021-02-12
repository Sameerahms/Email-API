package com.mobios.ep.web.models;

import com.ombios.ep.entity.model.Stats;



public class AppoinmentWM {
	
	private int id;
	private int appointmentNo;
	private int instituteId;
	private String appoinmentTime;
	private String appoinmentSession;
	private Patient patient;
	private Doctor doctor;
	//private Stats stats;
	private AppointmentStats stats;
	private boolean hasPrescription;
	//private SessionWM sessionWM;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getAppoinmentTime() {
		return appoinmentTime;
	}
	public void setAppoinmentTime(String appoinmentTime) {
		this.appoinmentTime = appoinmentTime;
	}
	public String getAppoinmentSession() {
		return appoinmentSession;
	}
	public void setAppoinmentSession(String appoinmentSession) {
		this.appoinmentSession = appoinmentSession;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getAppointmentNo() {
		return appointmentNo;
	}
	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}
	public AppointmentStats getStats() {
		return stats;
	}
	public void setStats(AppointmentStats stats) {
		this.stats = stats;
	}
	/*public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}*/
	/*public SessionWM getSessionWM() {
		return sessionWM;
	}
	public void setSessionWM(SessionWM sessionWM) {
		this.sessionWM = sessionWM;
	}
	*/
	public boolean getHasPrescription() {
		return hasPrescription;
	}
	public void setHasPrescription(boolean hasPrescription) {
		this.hasPrescription = hasPrescription;
	}

	
}
