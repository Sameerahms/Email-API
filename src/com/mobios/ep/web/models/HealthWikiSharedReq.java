/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class HealthWikiSharedReq {
	private int id;
	private int doctorId;
	private int healthWikiId;
	private int patientId;
	
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
	public int getHealthWikiId() {
		return healthWikiId;
	}
	public void setHealthWikiId(int healthWikiId) {
		this.healthWikiId = healthWikiId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "HealthWikiSharedReq [id=" + id + ", doctorId=" + doctorId
				+ ", healthWikiId=" + healthWikiId + ", patientId=" + patientId
				+ "]";
	}


}
