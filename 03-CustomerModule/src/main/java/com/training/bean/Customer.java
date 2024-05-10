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
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_seq"
            )
    @SequenceGenerator(
            name = "customer_seq",
            sequenceName = "customer_seq",
            allocationSize = 1
            )
	private int customerId;
	@ManyToOne
	private User user;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Customer(int customerId, User user) {
		super();
		this.customerId = customerId;
		this.user = user;
	}
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
	public Customer(User user) {
		super();
		this.user = user;
	}
	public Customer() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId);
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
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", user=" + user + "]";
	}

	
}
