/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Map;

/**
 * @author Nishantha
 *
 */
public class StatsWM {
	private int id;
	private int patientId;
	private int appointmentId;
	private String createdDateTime;	
	private Map<String, Object> stats;
	
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
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	public Map<String, Object> getStats() {
		return stats;
	}
	public void setStats(Map<String, Object> stats) {
		this.stats = stats;
	}
	@Override
	public String toString() {
		return "StatsWM [id=" + id + ", patientId=" + patientId
				+ ", appointmentId=" + appointmentId + ", createdDateTime="
				+ createdDateTime + ", stats=" + stats + "]";
	}
	
	

}
