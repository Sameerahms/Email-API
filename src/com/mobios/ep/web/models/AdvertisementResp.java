package com.mobios.ep.web.models;

/**
 * @author Supun Madara
 *
 */
public class AdvertisementResp {
	private int advertismentId;
	private String advertismentName;
	private int isActive;
	private String advertismentPath;
	
	public int getAdvertismentId() {
		return advertismentId;
	}
	public void setAdvertismentId(int advertismentId) {
		this.advertismentId = advertismentId;
	}
	public String getAdvertismentName() {
		return advertismentName;
	}
	public void setAdvertismentName(String advertismentName) {
		this.advertismentName = advertismentName;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getAdvertismentPath() {
		return advertismentPath;
	}
	public void setAdvertismentPath(String advertismentPath) {
		this.advertismentPath = advertismentPath;
	}
}
