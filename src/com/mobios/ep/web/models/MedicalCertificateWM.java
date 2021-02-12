/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class MedicalCertificateWM {
	private int id;
	private int doctorId;
	private int patientId;
	private int instituteId;
	private String residentialAddress;
	private String whereEmployed;
	private String natureOfDiseases;
	private String recommendedDays;
	private String leaveWithEffectFrom;
	
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
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getWhereEmployed() {
		return whereEmployed;
	}
	public void setWhereEmployed(String whereEmployed) {
		this.whereEmployed = whereEmployed;
	}
	public String getNatureOfDiseases() {
		return natureOfDiseases;
	}
	public void setNatureOfDiseases(String natureOfDiseases) {
		this.natureOfDiseases = natureOfDiseases;
	}
	public String getRecommendedDays() {
		return recommendedDays;
	}
	public void setRecommendedDays(String recommendedDays) {
		this.recommendedDays = recommendedDays;
	}
	public String getLeaveWithEffectFrom() {
		return leaveWithEffectFrom;
	}
	public void setLeaveWithEffectFrom(String leaveWithEffectFrom) {
		this.leaveWithEffectFrom = leaveWithEffectFrom;
	}
	@Override
	public String toString() {
		return "MedicalCertificateWM [id=" + id + ", doctorId=" + doctorId
				+ ", patientId=" + patientId + ", instituteId=" + instituteId
				+ ", residentialAddress=" + residentialAddress
				+ ", whereEmployed=" + whereEmployed + ", natureOfDiseases="
				+ natureOfDiseases + ", recommendedDays=" + recommendedDays
				+ ", leaveWithEffectFrom=" + leaveWithEffectFrom + "]";
	}

		

}
