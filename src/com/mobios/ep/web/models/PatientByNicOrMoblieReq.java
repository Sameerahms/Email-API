/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class PatientByNicOrMoblieReq {
	private int instituteId;
	private String nic;
	private String mobile;
	
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "PatientByNicOrMoblieReq [instituteId=" + instituteId + ", nic="
				+ nic + ", mobile=" + mobile + "]";
	}

}
