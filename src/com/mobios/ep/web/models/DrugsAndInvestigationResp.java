/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class DrugsAndInvestigationResp {
	private String date;
	private int instituteId;
	private String prescribedDrugs[];
	private String prescribedInvestigations[];
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String[] getPrescribedDrugs() {
		return prescribedDrugs;
	}
	public void setPrescribedDrugs(String[] prescribedDrugs) {
		this.prescribedDrugs = prescribedDrugs;
	}
	public String[] getPrescribedInvestigations() {
		return prescribedInvestigations;
	}
	public void setPrescribedInvestigations(String[] prescribedInvestigations) {
		this.prescribedInvestigations = prescribedInvestigations;
	}
	@Override
	public String toString() {
		return "DrugsAndInvestigationResp [date=" + date + ", instituteId="
				+ instituteId + ", prescribedDrugs="
				+ Arrays.toString(prescribedDrugs)
				+ ", prescribedInvestigations="
				+ Arrays.toString(prescribedInvestigations) + "]";
	}
	
	

}
