/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvoiceListByDatesReq {
	private String startDate;
	private String endDate;
	private int instituteId;
	
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
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	@Override
	public String toString() {
		return "InvoiceListByDatesReq [startDate=" + startDate + ", endDate="
				+ endDate + ", instituteId=" + instituteId + "]";
	}
	

}
