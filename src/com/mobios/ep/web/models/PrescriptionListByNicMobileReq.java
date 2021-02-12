/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class PrescriptionListByNicMobileReq {
	private String nic;
	private int instituteId;
	private String date;
	private String mobile;
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "PrescriptionListByNicMobileReq [nic=" + nic + ", instituteId="
				+ instituteId + ", date=" + date + ", mobile=" + mobile + "]";
	}

}
