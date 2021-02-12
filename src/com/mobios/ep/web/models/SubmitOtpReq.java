package com.mobios.ep.web.models;
/*
Modal for the requests comming to submit OTP

*/
public class SubmitOtpReq {
	
	private String referenceId;
	private int otp;
	private String imei;
	private String timestamp;	
	
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "SubmitOtpReq [referenceId=" + referenceId + ", otp=" + otp
				+ ", imei=" + imei + ", timestamp=" + timestamp + "]";
	}
	
}
