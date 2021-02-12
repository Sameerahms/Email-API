/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nishantha
 *
 */
public class UpdateMobileReq {
	private int ids[];
	private String mobile;
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UpdateMobileReq [ids=" + Arrays.toString(ids) + ", mobile="
				+ mobile + "]";
	}
		
	
}