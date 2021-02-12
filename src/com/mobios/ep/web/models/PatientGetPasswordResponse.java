package com.mobios.ep.web.models;

public class PatientGetPasswordResponse {

	private String password;
	private boolean isValid;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getIsValid() {
		return isValid;
	}
	
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
}
