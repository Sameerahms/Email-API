/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * Web model class of Institute
 * 
 * @author Nishantha
 *
 */
public class InstituteWM {
	private int id;
	private String name;
	private String prescriptionHeader1;
	private String prescriptionHeader2;
	private String prescriptionMoto;
	private String prescriptionAddress1;
	private String prescriptionAddress2;
	private String city;
	private String prescriptionPhone;
	private String prescriptionEmail;
	private String prescriptionURL;
	private String imageURL;
	private String type;
	private String latitude;
	private String longitude;
	private String referenceId;
	private String licenseStartDate;
	private String licenseEndDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrescriptionHeader1() {
		return prescriptionHeader1;
	}
	public void setPrescriptionHeader1(String prescriptionHeader1) {
		this.prescriptionHeader1 = prescriptionHeader1;
	}
	public String getPrescriptionHeader2() {
		return prescriptionHeader2;
	}
	public void setPrescriptionHeader2(String prescriptionHeader2) {
		this.prescriptionHeader2 = prescriptionHeader2;
	}
	public String getPrescriptionMoto() {
		return prescriptionMoto;
	}
	public void setPrescriptionMoto(String prescriptionMoto) {
		this.prescriptionMoto = prescriptionMoto;
	}
	public String getPrescriptionAddress1() {
		return prescriptionAddress1;
	}
	public void setPrescriptionAddress1(String prescriptionAddress1) {
		this.prescriptionAddress1 = prescriptionAddress1;
	}
	public String getPrescriptionAddress2() {
		return prescriptionAddress2;
	}
	public void setPrescriptionAddress2(String prescriptionAddress2) {
		this.prescriptionAddress2 = prescriptionAddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPrescriptionPhone() {
		return prescriptionPhone;
	}
	public void setPrescriptionPhone(String prescriptionPhone) {
		this.prescriptionPhone = prescriptionPhone;
	}
	public String getPrescriptionEmail() {
		return prescriptionEmail;
	}
	public void setPrescriptionEmail(String prescriptionEmail) {
		this.prescriptionEmail = prescriptionEmail;
	}
	public String getPrescriptionURL() {
		return prescriptionURL;
	}
	public void setPrescriptionURL(String prescriptionURL) {
		this.prescriptionURL = prescriptionURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getLicenseStartDate() {
		return licenseStartDate;
	}
	public void setLicenseStartDate(String licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}
	public String getLicenseEndDate() {
		return licenseEndDate;
	}
	public void setLicenseEndDate(String licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}
	@Override
	public String toString() {
		return "InstituteWM [id=" + id + ", name=" + name
				+ ", prescriptionHeader1=" + prescriptionHeader1
				+ ", prescriptionHeader2=" + prescriptionHeader2
				+ ", prescriptionMoto=" + prescriptionMoto
				+ ", prescriptionAddress1=" + prescriptionAddress1
				+ ", prescriptionAddress2=" + prescriptionAddress2 + ", city="
				+ city + ", prescriptionPhone=" + prescriptionPhone
				+ ", prescriptionEmail=" + prescriptionEmail
				+ ", prescriptionURL=" + prescriptionURL + ", imageURL="
				+ imageURL + ", type=" + type + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", referenceId=" + referenceId
				+ ", licenseStartDate=" + licenseStartDate
				+ ", licenseEndDate=" + licenseEndDate + "]";
	}
	

}
