package com.mobios.ep.web.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ombios.ep.entity.model.Institute;

public class InvestigationEmailInfoM {
	
	private int Id;
	
	private int prescriptionId;

	private int doctorHospitalId;
	
	private int doctorId;
	
	private String createdDate;
	
	private String Checked;
	
	private Doctor doctor;
	
	private Institute institute;
	
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorHospitalId(int doctorHospitalId) {
		this.doctorHospitalId = doctorHospitalId;
	}
	public int getDoctorHospitalId() {
		return doctorHospitalId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getChecked() {
		return Checked;
	}
	public void setChecked(String Checked) {
		this.Checked = Checked;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
}
