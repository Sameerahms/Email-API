package com.mobios.ep.web.models;

public class ReferralLetter_History {

	private int id;
	private int referralletterId;
	private String referralletter;
	private String createdDate;
	private String userCreated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReferralletterId() {
		return referralletterId;
	}
	public void setReferralletterId(int referralletterId) {
		this.referralletterId = referralletterId;
	}
	public String getReferralletter() {
		return referralletter;
	}
	public void setReferralletter(String referralletter) {
		this.referralletter = referralletter;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	
}
