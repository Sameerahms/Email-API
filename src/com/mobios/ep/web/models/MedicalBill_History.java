package com.mobios.ep.web.models;

public class MedicalBill_History {

	private int id;
	private int medicalbillId;
	private String medicalbill;
	private String createdDate;
	private String userCreated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMedicalbillId() {
		return medicalbillId;
	}
	public void setMedicalbillId(int medicalbillId) {
		this.medicalbillId = medicalbillId;
	}
	public String getMedicalbill() {
		return medicalbill;
	}
	public void setMedicalbill(String medicalbill) {
		this.medicalbill = medicalbill;
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
