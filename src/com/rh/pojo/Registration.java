package com.rh.pojo;

import java.util.Date;

public class Registration {

	private long RegID;
	private String FirstName;
	private String LastName;
	private String email;
	private String Company;
	private String country;
	private String mobile;
	private String password;
	private Date creation_time;
	private Date last_update_time;
	private String referal_code;
	public long getRegID() {
		return RegID;
	}
	public void setRegID(long regID) {
		RegID = regID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public Date getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	public String getReferal_code() {
		return referal_code;
	}
	public void setReferal_code(String referal_code) {
		this.referal_code = referal_code;
	}
	
}
