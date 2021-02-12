/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvoiceWM {
	private int id;
	/*private int patientId;
	private int doctorId;*/
	private int instituteId;
	private int prescriptionId;
	private double amount;
	private double vat;
	private double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}*/
	
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "InvoiceWM [id=" + id + ", instituteId=" + instituteId
				+ ", prescriptionId=" + prescriptionId + ", amount=" + amount
				+ ", vat=" + vat + ", total=" + total + "]";
	}
	
	
}
