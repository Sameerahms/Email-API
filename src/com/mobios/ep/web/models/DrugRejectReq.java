/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Administrator
 *
 */
public class DrugRejectReq {
	private int id;
	private String rejectReason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	@Override
	public String toString() {
		return "DrugRejectReq [id=" + id + ", rejectReason=" + rejectReason
				+ "]";
	}

	
}
