package com.mobios.ep.web.models;

import com.ombios.ep.entity.model.Stats;

public class AppointmentReq {
	private int id;
	private int patientId;
	private int doctorId;
	private int noOfAppointment;
	private int instituteId;
	private String appointmentDate;
	private String appointmentTime;
	private int sessionId;
	private AppointmentStats stats;
	//private String statsJson;
	
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
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getNoOfAppointment() {
		return noOfAppointment;
	}
	public void setNoOfAppointment(int noOfAppointment) {
		this.noOfAppointment = noOfAppointment;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}	
	public AppointmentStats getStats() {
		return stats;
	}
	public void setStats(AppointmentStats stats) {
		this.stats = stats;
	}
	
	/*public String getStatsJson() {
		return statsJson;
	}
	public void setStatsJson(String statsJson) {
		this.statsJson = statsJson;
	}*/
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	@Override
	public String toString() {
		return "AppointmentReq [id=" + id + ", patientId=" + patientId
				+ ", doctorId=" + doctorId + ", noOfAppointment="
				+ noOfAppointment + ", instituteId=" + instituteId
				+ ", appointmentDate=" + appointmentDate + ", appointmentTime="
				+ appointmentTime + ", sessionId=" + sessionId + ", stats="
				+ stats + "]";
	}
	
	
	
	

}
