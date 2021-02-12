package com.mobios.ep.web.models;

public class PatientGetPassword {

	private String nic;
	private String mobile;
	private String password;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PatientGetPassword [nic=" + nic + ",mobile=" + mobile + "]";
			
	}
}
