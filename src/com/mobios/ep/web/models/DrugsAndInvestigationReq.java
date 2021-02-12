/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class DrugsAndInvestigationReq {
	private int doctorId;
	private String startDate;
	private String endDate;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
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
	@Override
	public String toString() {
		return "DrugsAndInvestigationResp [doctorId=" + doctorId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
