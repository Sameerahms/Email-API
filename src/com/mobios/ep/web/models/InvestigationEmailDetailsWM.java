/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvestigationEmailDetailsWM {
	
	private int institudeId;
	
	
	public int getInstitudeId() {
		return institudeId;
	}
	public void setInstitudeId(int institudeId) {
		this.institudeId = institudeId;
	}
	@Override
	public String toString() {
		return "InvestigationEmailDetailsWM [ institudeId=" + institudeId + "]";
	}

}
