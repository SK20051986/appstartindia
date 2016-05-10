package com.rh.pojo;

import java.util.Date;

public class MyWallet {
	private long RegID;
	private double amount;
	private String Promo_code;
	private String Company;
	private String email;
	private String Billing_address;
	private String Transaction_Id;
	private String Transaction_Status;
	private Date creation_time;
	private Date last_update_time;
	private String mobile;
	public long getRegID() {
		return RegID;
	}
	public void setRegID(long regID) {
		RegID = regID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPromo_code() {
		return Promo_code;
	}
	public void setPromo_code(String promo_code) {
		Promo_code = promo_code;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBilling_address() {
		return Billing_address;
	}
	public void setBilling_address(String billing_address) {
		Billing_address = billing_address;
	}
	public String getTransaction_Id() {
		return Transaction_Id;
	}
	public void setTransaction_Id(String transaction_Id) {
		Transaction_Id = transaction_Id;
	}
	public String getTransaction_Status() {
		return Transaction_Status;
	}
	public void setTransaction_Status(String transaction_Status) {
		Transaction_Status = transaction_Status;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
