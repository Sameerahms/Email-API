/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class DoctorReq {
	private int instituteId;

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	@Override
	public String toString() {
		return "DoctorReq [instituteId=" + instituteId + "]";
	}

}
