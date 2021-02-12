/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class PasswordResetReq {
	private String username;
	private String password;
	private String resetCode;
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
	public String getResetCode() {
		return resetCode;
	}
	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}
	@Override
	public String toString() {
		return "PasswordResetReq [username=" + username + ", password="
				+ password + ", resetCode=" + resetCode + "]";
	}
	
	

}
