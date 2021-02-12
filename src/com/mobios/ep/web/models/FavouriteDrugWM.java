/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class FavouriteDrugWM {
	private int id;
	private int doctorId;
	private int drugId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	@Override
	public String toString() {
		return "FavouriteDrugWM [id=" + id + ", doctorId=" + doctorId
				+ ", drugId=" + drugId + "]";
	}
	

}
