package com.training.bean;

import java.util.Objects;


public class Customer extends AbstractUser{

	private int customerId;
	
	
	
	
	public Customer(String userName, String password, String address, String email, String mobileNumber,
			int customerId) {
		super(userName, password, address, email, mobileNumber);
		this.customerId = customerId;
	}
	




	public Customer(String userName, String password, String address, String email, String mobileNumber) {
		super(userName, password, address, email, mobileNumber);
	}





	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getAddress()=" + getAddress() + ", getEmail()=" + getEmail()
				+ ", getMobileNumber()=" + getMobileNumber() + ", hashCode()=" + hashCode() + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerId == other.customerId;
	}
	public Customer() {
        // Default constructor
    }
	

	
}
