package com.training.bean;

import java.util.Objects;


public class Admin  extends AbstractUser{

	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Admin(String userName, String password, String address, String email, String mobileNumber, int adminId) {
		super(userName, password, address, email, mobileNumber);
		this.adminId = adminId;
	}

	public Admin(String userName, String password, String address, String email, String mobileNumber) {
		super(userName, password, address, email, mobileNumber);
	}

	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
				+ ", getAddress()=" + getAddress() + ", getEmail()=" + getEmail() + ", getMobileNumber()="
				+ getMobileNumber() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return adminId == other.adminId;
	}
	
	

}
