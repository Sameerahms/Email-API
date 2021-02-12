/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class MedicalBillWM {
	private int id;
	private double doctorFee; 	
	private double drugs; 	
	private double investigations; 	
	private double other;	
	private int	patientId;
	private int doctorId;
	private int instituteId;
	private String homeAddress;	
	private String officeAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
	}
	public double getDrugs() {
		return drugs;
	}
	public void setDrugs(double drugs) {
		this.drugs = drugs;
	}
	public double getInvestigations() {
		return investigations;
	}
	public void setInvestigations(double investigations) {
		this.investigations = investigations;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public int getPatientId() {
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
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Override
	public String toString() {
		return "MedicalBillWM [id=" + id + ", doctorFee=" + doctorFee
				+ ", drugs=" + drugs + ", investigations=" + investigations
				+ ", other=" + other + ", patientId=" + patientId
				+ ", doctorId=" + doctorId + ", instituteId=" + instituteId
				+ ", homeAddress=" + homeAddress + ", officeAddress="
				+ officeAddress + "]";
	}
	

}
