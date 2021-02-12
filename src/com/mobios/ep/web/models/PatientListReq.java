/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class PatientListReq {
	private int patients[];

	public int[] getPatients() {
		return patients;
	}

	public void setPatients(int[] patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "PatientListReq [patients=" + Arrays.toString(patients) + "]";
	}

}
