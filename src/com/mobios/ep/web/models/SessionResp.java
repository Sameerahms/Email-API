/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class SessionResp {
	private int id;
	private int roomNo;
	private int instituteId;
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
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
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
		return "SessionResp [id=" + id + ", roomNo=" + roomNo
				+ ", instituteId=" + instituteId + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", isDeleted=" + isDeleted + "]";
	}

}
