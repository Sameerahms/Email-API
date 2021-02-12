package com.mobios.ep.web.models;

import java.sql.Date;

public class RequestDiagnosticsWM {
	
	private int id;	
	private int createdBy;
	private Date createdDate;
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
