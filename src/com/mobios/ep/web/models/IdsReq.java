/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class IdsReq {
	private int[] ids;

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "IdsReq [ids=" + Arrays.toString(ids) + "]";
	}
	

}
