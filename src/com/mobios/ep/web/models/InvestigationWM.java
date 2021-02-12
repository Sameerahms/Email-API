/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvestigationWM {
	private int id;
	private int testId;
	private int doctorId;
	private String test;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "InvestigationWM [id=" + id + ", testId=" + testId
				+ ", doctorId=" + doctorId + ", test=" + test + "]";
	}

}
