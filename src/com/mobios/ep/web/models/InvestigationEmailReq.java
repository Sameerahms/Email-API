/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.Arrays;

/**
 * @author Nishantha
 *
 */
public class InvestigationEmailReq {
	private int doctorId;
	private int instituteIds[];
	private String test;
	private String diagnosis;
	private String pName;
	private int pAge;
	private String gender;
	private String doctorName;
	private String doctorEmail;
	private String doctorHospitalName;
	private String doctorHospitalAddress1;
	private String doctorHospitalAddress2;
	private String doctorMobile;
	private String image;
	private int insEmailId;
	
	
	
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int[] getInstituteIds() {
		return instituteIds;
	}
	public void setInstituteIds(int[] instituteIds) {
		this.instituteIds = instituteIds;
	}
	public String gettest() {
		return test;
	}
	public void setMessage(String test) {
		this.test = test;
	}
	public String getdiagnosis() {
		return diagnosis;
	}
	public void setdiagnosis(String diagnosis) {
		this.diagnosis= diagnosis;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpAge() {
		return pAge;
	}
	public void setToDate(int pAge) {
		this.pAge = pAge;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getdoctorEmail() {
		return doctorEmail;
	}
	public void setdoctorEmail(String doctorEmail) {
		this.doctorEmail= doctorEmail;
	}
	public String getdoctorHospitalName() {
		return doctorHospitalName;
	}
	public void setdoctorHospitalName(String doctorHospitalName) {
		this.doctorHospitalName = doctorHospitalName;
	}
	public String getdoctorHospitalAddress1() {
		return doctorHospitalAddress1;
	}
	public void setdoctorHospitalAddress1(String doctorHospitalAddress1) {
		this.doctorHospitalAddress1 = doctorHospitalAddress1;
	}
	public String getdoctorHospitalAddress2() {
		return doctorHospitalAddress2;
	}
	public void setdoctorHospitalAddress2(String doctorHospitalAddress2) {
		this.doctorHospitalAddress2 = doctorHospitalAddress2;
	}
	public String getdoctorMobile() {
		return doctorMobile;
	}
	public void setdoctorMobile(String doctorMobile) {
		this.doctorMobile =doctorMobile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image =image;
	}
	public int getinsEmailId() {
		return insEmailId;
	}
	public void setinsEmailId(int insEmailId) {
		this.insEmailId =insEmailId;
	}
	@Override
	public String toString() {
		return "InvestigationEmailReq [doctorId=" + doctorId + ", instituteIds="
				+ Arrays.toString(instituteIds) + ", test=" + test
				+ ", diagnosis=" + diagnosis + ", pName=" + pName + ", pAge="
				+ pAge +  ", gender=" + gender + ", doctorName=" + doctorName + ", doctorEmail=" +doctorEmail+  ", doctorHospitalName=" + doctorHospitalName +  ", doctorHospitalAddress1=" + doctorHospitalAddress1 +  ", doctorHospitalAddress2=" + doctorHospitalAddress2 +  ", doctorMobile=" + doctorMobile + ", image=" + image+ ", insEmailId=" + insEmailId+"]";
	}
	
	
}
