/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class BloodGroupReq {
	
	private int id;
	private int doctorId;
	private String bloodGroup;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String toString() {
		return "BloodGroupReq [id=" + id + ", doctorId=" + doctorId
				+ ", bloodGroup=" + bloodGroup + "]";
	}
	

}
