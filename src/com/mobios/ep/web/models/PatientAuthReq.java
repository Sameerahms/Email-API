/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class PatientAuthReq {
	private String nic;
	private String parentNIC;
	private String mobile;
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getParentNIC() {
		return parentNIC;
	}
	public void setParentNIC(String parentNIC) {
		this.parentNIC = parentNIC;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "PatientAuthReq [nic=" + nic + ", parentNIC=" + parentNIC
				+ ", mobile=" + mobile + "]";
	}
	

}
