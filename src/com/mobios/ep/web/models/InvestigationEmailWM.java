/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class InvestigationEmailWM {
	private int Id;
	private int prescriptionId;
	private int doctorId;
	private int doctorHospitalId;
	private int institudeId;
	
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id= Id;
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId= prescriptionId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getDoctorHospitalId() {
		return doctorHospitalId;
	}
	public void setDoctorHospitalId(int doctorHospitalId) {
		this.doctorHospitalId= doctorHospitalId;
	}
	public int getInstitudeId() {
		return institudeId;
	}
	public void setInstitudeId(int institudeId) {
		this.institudeId = institudeId;
	}
	@Override
	public String toString() {
		return "InvestigationEmailWM [Id=" + Id + ", prescriptionId=" + prescriptionId
				+ ", doctorId=" + doctorId + ", doctorHospitalId=" + doctorHospitalId +", institudeId=" + institudeId + "]";
	}

}
