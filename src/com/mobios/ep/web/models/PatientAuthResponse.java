/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class PatientAuthResponse {
	private int authenStatus;

	public int getAuthenStatus() {
		return authenStatus;
	}

	public void setAuthenStatus(int authenStatus) {
		this.authenStatus = authenStatus;
	}

	@Override
	public String toString() {
		return "PatientAuthReq [authenStatus=" + authenStatus + "]";
	} 
	

}
