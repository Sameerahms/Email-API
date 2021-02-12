/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.List;

import com.ombios.ep.entity.model.Institute;

/**
 * @author Nishantha
 *
 */
public class PrescriptionResp {
	private int id;
	private String uuid;
	private int appointmentId;
	private int appointmentNo;
	private int instituteId;
	private int doctorId;
	private String bloodPressure1;
	private String bloodPressure2;
	private String diagnosis;
	private String height;
	private String nextVisitDate;
	private String pulseRate;
	private String weight;
	private String tests;
	private String temperature;
	private String comments;
	private String createdDate;
	private boolean hasInvoiced;
	private Patient patient;
	private Doctor doctor;
	private Institute institute;
	private List<PrescriptionDrugs> drugs;
	private int sessionId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getAppointmentNo() {
		return appointmentNo;
	}
	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getBloodPressure1() {
		return bloodPressure1;
	}
	public void setBloodPressure1(String bloodPressure1) {
		this.bloodPressure1 = bloodPressure1;
	}
	public String getBloodPressure2() {
		return bloodPressure2;
	}
	public void setBloodPressure2(String bloodPressure2) {
		this.bloodPressure2 = bloodPressure2;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getNextVisitDate() {
		return nextVisitDate;
	}
	public void setNextVisitDate(String nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}
	public String getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isHasInvoiced() {
		return hasInvoiced;
	}
	public void setHasInvoiced(boolean hasInvoiced) {
		this.hasInvoiced = hasInvoiced;
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
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public List<PrescriptionDrugs> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<PrescriptionDrugs> drugs) {
		this.drugs = drugs;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "PrescriptionResp [id=" + id + ", uuid=" + uuid
				+ ", appointmentId=" + appointmentId + ", appointmentNo="
				+ appointmentNo + ", instituteId=" + instituteId
				+ ", doctorId=" + doctorId + ", bloodPressure1="
				+ bloodPressure1 + ", bloodPressure2=" + bloodPressure2
				+ ", diagnosis=" + diagnosis + ", height=" + height
				+ ", nextVisitDate=" + nextVisitDate + ", pulseRate="
				+ pulseRate + ", weight=" + weight + ", tests=" + tests
				+ ", temperature=" + temperature + ", comments=" + comments
				+ ", createdDate=" + createdDate + ", hasInvoiced="
				+ hasInvoiced + ", patient=" + patient + ", doctor=" + doctor
				+ ", institute=" + institute + ", drugs=" + drugs
				+ ", sessionId=" + sessionId + "]";
	}
	

}
