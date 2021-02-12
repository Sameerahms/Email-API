package com.mobios.ep.web.models;

import java.util.Date;

public class Patient {
	
	private int id;
	private String title;
	private String firstName;
	private String lastName;
	private int age;
	private String mobileNo;
	private String nic;
	private String parentNIC;
	private String email;
	private String address;
	private String gender;
	private String userType;
	private String userRole;
	private String createdDate;
	private String createdBy;
	private String bloodGroup;
	private String dateOfBirth;
	private String passportNo;
	
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getMobile() {
		return mobileNo;
	}
	public void setMobile(String mobile) {
		this.mobileNo = mobile;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getParentNIC() {
		return parentNIC;
	}
	public void setParentNIC(String parentNIC) {
		this.parentNIC = parentNIC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", title=" + title + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age
				+ ", mobileNo=" + mobileNo + ", nic=" + nic + ", parentNIC="
				+ parentNIC + ", email=" + email + ", address=" + address
				+ ", gender=" + gender + ", userType=" + userType
				+ ", userRole=" + userRole + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", bloodGroup=" + bloodGroup
				+ ", dateOfBirth=" + dateOfBirth + ",passportNo=" + passportNo+"]";
	}
	

}
