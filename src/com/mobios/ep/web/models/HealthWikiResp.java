/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.List;

/**
 * @author Nishantha
 *
 */
public class HealthWikiResp {
	private int patientId;	
	private String firstname;
	private String lastname;
	private  List<HealthWikiWM> healthWikis;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<HealthWikiWM> getHealthWikis() {
		return healthWikis;
	}
	public void setHealthWikis(List<HealthWikiWM> healthWikis) {
		this.healthWikis = healthWikis;
	}
	@Override
	public String toString() {
		return "HealthWikiResp [patientId=" + patientId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", healthWikis="
				+ healthWikis + "]";
	}
	
	
	
}
