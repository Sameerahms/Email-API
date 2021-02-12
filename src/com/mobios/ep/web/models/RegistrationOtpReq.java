package com.mobios.ep.web.models;

/*
Model for mobile user registration otp request
*/
public class RegistrationOtpReq {

	private String mobile;
	private String otp;
	private String referenceId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
