package com.training.bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@MappedSuperclass
public class AbstractUser {
	
	
	
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String email;
	@Column
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
