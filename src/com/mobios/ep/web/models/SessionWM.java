/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class SessionWM {
	private int id;
	private int roomNo;
	private String date;
	private String startTime;
	private String endTime;
	private int isDeleted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "SessionWM [id=" + id + ", roomNo=" + roomNo + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", isDeleted=" + isDeleted + "]";
	}
	


}
