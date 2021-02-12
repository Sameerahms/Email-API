/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class DoctorProfileWM {
	private int id;
	private int doctorId;
	private String title;
	private String others;
	private String firstName;
	private String lastName;
	private int age;
	private String nic;
	private String gender;
	private String printName;
	private String homeAddressNo;
	private String streetName1;
	private String streetName2;
	private String town;
	private String district;
	private String facebookUrl;
	private String linkedInUrl;
	private String homeLandTelNo;
	private String mobile;
	private String mobileNo1;
	private String mobileNo2;
	private String email;
	private String email1;
	private String email2;
	private String[] visitingHospitals;
	private String otherHospitals;
	private String imagePath;
	private String userType;
	private Info info;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}
	public String getHomeAddressNo() {
		return homeAddressNo;
	}
	public void setHomeAddressNo(String homeAddressNo) {
		this.homeAddressNo = homeAddressNo;
	}
	public String getStreetName1() {
		return streetName1;
	}
	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}
	public String getStreetName2() {
		return streetName2;
	}
	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public String getHomeLandTelNo() {
		return homeLandTelNo;
	}
	public void setHomeLandTelNo(String homeLandTelNo) {
		this.homeLandTelNo = homeLandTelNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobileNo1() {
		return mobileNo1;
	}
	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}
	public String getMobileNo2() {
		return mobileNo2;
	}
	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	public String[] getVisitingHospitals() {
		return visitingHospitals;
	}
	public void setVisitingHospitals(String[] visitingHospitals) {
		this.visitingHospitals = visitingHospitals;
	}
	public String getOtherHospitals() {
		return otherHospitals;
	}
	public void setOtherHospitals(String otherHospitals) {
		this.otherHospitals = otherHospitals;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "DoctorProfileWM [id=" + id + ", doctorId=" + doctorId
				+ ", title=" + title + ", others=" + others + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age
				+ ", nic=" + nic + ", gender=" + gender + ", printName="
				+ printName + ", homeAddressNo=" + homeAddressNo
				+ ", streetName1=" + streetName1 + ", streetName2="
				+ streetName2 + ", town=" + town + ", district=" + district
				+ ", facebookUrl=" + facebookUrl + ", linkedInUrl="
				+ linkedInUrl + ", homeLandTelNo=" + homeLandTelNo
				+ ", mobile=" + mobile + ", mobileNo1=" + mobileNo1
				+ ", mobileNo2=" + mobileNo2 + ", email=" + email + ", email1="
				+ email1 + ", email2=" + email2 + ", visitingHospitals="
				+ visitingHospitals + ", otherHospitals=" + otherHospitals
				+ ", imagePath=" + imagePath + ", userType=" + userType
				+ ", info=" + info + "]";
	}
	

}
