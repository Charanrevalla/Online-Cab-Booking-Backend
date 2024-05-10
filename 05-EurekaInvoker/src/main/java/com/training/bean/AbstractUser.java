package com.training.bean;

import java.util.Objects;


public class AbstractUser {
	
	
	

	private String userName;

	private String password;

	private String address;

	private String email;
	
	private String mobileNumber;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public AbstractUser(String userName, String password, String address, String email, String mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	

	public AbstractUser() {
		super();
	}

	@Override
	public String toString() {
		return "AbstractUser [userName=" + userName + ", password=" + password + ", address=" + address + ", email="
				+ email + ", mobileNumber=" + mobileNumber + "]";
	}

	


	
	
}
