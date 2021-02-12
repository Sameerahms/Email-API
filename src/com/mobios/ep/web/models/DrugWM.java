package com.mobios.ep.web.models;

import java.util.Arrays;

/*
 * Drug web model returning to client app
 * TODO: fill this model 
 */
public class DrugWM {
	
	private int id;
	private int doctorId;
	private String tradeName;
	private String genericName;
	private String rawName;
	private String[] weight;
	private String defaultWeight;
	private String defaultFrequency;
	private String category;
	private long lastUpdatedTime;
	private String status;
	private boolean hasVerified;
	private int enable;
	private String rejectReason;
	
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
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	
	public String getRawName() {
		return rawName;
	}
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
	public String[] getWeight() {
		return weight;
	}
	public void setWeight(String[] weight) {
		this.weight = weight;
	}
	public String getDefaultWeight() {
		return defaultWeight;
	}
	public void setDefaultWeight(String defaultWeight) {
		this.defaultWeight = defaultWeight;
	}
	public String getDefaultFrequency() {
		return defaultFrequency;
	}
	public void setDefaultFrequency(String defaultFrequency) {
		this.defaultFrequency = defaultFrequency;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(long lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isHasVerified() {
		return hasVerified;
	}
	public void setHasVerified(boolean hasVerified) {
		this.hasVerified = hasVerified;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
			
}
