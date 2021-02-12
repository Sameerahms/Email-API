package com.mobios.ep.web.models;

public class PastDiseases {
	
	private int id;
	private String name;
	private int aging;
	private String status;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAging() {
		return aging;
	}
	public void setAging(int aging) {
		this.aging = aging;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
