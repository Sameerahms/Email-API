/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class PrescriptionSummaryReq {

	private String startDate;
	private String endDate;
	private int doctorId;
	private int[] institutes;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int[] getInstitutes() {
		return institutes;
	}
	public void setInstitutes(int[] institutes) {
		this.institutes = institutes;
	}
	@Override
	public String toString() {
		return "PrescriptionSummaryReq [startDate=" + startDate + ", endDate="
				+ endDate + ", doctorId=" + doctorId + ", institutes="
				+ Arrays.toString(institutes) + "]";
	}
	
}
