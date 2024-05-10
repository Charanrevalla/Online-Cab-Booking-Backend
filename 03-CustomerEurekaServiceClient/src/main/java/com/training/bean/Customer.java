package com.training.bean;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="customerss")
public class Customer extends AbstractUser{
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cus_seq"
            )
    @SequenceGenerator(
            name = "cus_seq",
            sequenceName = "customer_seq",
            allocationSize = 1
            )
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
