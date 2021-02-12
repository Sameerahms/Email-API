package com.mobios.ep.web.models;

public class LoginReq {
	
	private String username;
	private String password;
	private String clientId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	@Override
	 public String toString(){
	  return "{'username': "+username+" , 'password': "+password+" , 'clientId': "+clientId+" }";
	 }

}
