/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class SessionSummaryWM {
	private int totalNoOfAppointments;
	private int noOfPatientsWithPrescriptions;
	private int totalPrescriptions;
	
	public int getTotalNoOfAppointments() {
		return totalNoOfAppointments;
	}
	public void setTotalNoOfAppointments(int totalNoOfAppointments) {
		this.totalNoOfAppointments = totalNoOfAppointments;
	}
	public int getNoOfPatientsWithPrescriptions() {
		return noOfPatientsWithPrescriptions;
	}
	public void setNoOfPatientsWithPrescriptions(int noOfPatientsWithPrescriptions) {
		this.noOfPatientsWithPrescriptions = noOfPatientsWithPrescriptions;
	}
	public int getTotalPrescriptions() {
		return totalPrescriptions;
	}
	public void setTotalPrescriptions(int totalPrescriptions) {
		this.totalPrescriptions = totalPrescriptions;
	}
	@Override
	public String toString() {
		return "SessionSummaryWM [totalNoOfAppointments="
				+ totalNoOfAppointments + ", noOfPatientsWithPrescriptions="
				+ noOfPatientsWithPrescriptions + ", totalPrescriptions="
				+ totalPrescriptions + "]";
	}
	
	
	
}
