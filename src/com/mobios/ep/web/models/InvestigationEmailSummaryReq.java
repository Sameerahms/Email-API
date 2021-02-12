/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvestigationEmailSummaryReq {
	private int id;
	private int institudeId;
	private String startDate;
	private String endDate;
	private String status;
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstitudeId() {
		return institudeId;
	}
	public void setInstitudeId(int institudeId) {
		this.institudeId = institudeId;
	}
	
	public String getstartDate() {
		return startDate;
	}
	public void setstartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getendDate() {
		return endDate;
	}
	public void setInstitudeId(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "InvestigationEmailSummaryReq [ institudeId=" + institudeId + " startDate=" + startDate +" endDate=" + endDate +" id=" + id +" status=" + status + "]";
	}

}
