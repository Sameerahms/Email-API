/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class EmailReq {
	private int doctorId;
	private int instituteIds[];
	private String message;
	private String reason;
	private String fromDate;
	private String toDate;
	private String doctorName;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int[] getInstituteIds() {
		return instituteIds;
	}
	public void setInstituteIds(int[] instituteIds) {
		this.instituteIds = instituteIds;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	@Override
	public String toString() {
		return "EmailReq [doctorId=" + doctorId + ", instituteIds="
				+ Arrays.toString(instituteIds) + ", message=" + message
				+ ", reason=" + reason + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", doctorName=" + doctorName + "]";
	}
	
	
}
