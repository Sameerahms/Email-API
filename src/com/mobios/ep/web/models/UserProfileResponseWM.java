/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class UserProfileResponseWM {
	private String username;
	private String password;
	
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
	@Override
	public String toString() {
		return "UserProfileResponse [username=" + username + ", password="
				+ password + "]";
	}

}
