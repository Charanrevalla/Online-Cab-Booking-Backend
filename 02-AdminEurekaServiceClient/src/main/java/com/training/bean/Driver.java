package com.training.bean;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="drivers")
public class Driver extends AbstractUser{
	
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dvr_seq"
            )
    @SequenceGenerator(
            name = "dvr_seq",
            sequenceName = "driver_seq",
            allocationSize = 1
            )
	private int driverId;
	@Column
	private String licenceNo; 
	@OneToOne(cascade = CascadeType.ALL)
	
	private Cab cab;
	@Column
	private float rating;
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	
	
	
	public Driver(String userName, String password, String address, String email, String mobileNumber) {
		super(userName, password, address, email, mobileNumber);
	}
	public Driver(String userName, String password, String address, String email, String mobileNumber, int driverId,
			String licenceNo, Cab cab, float rating) {
		super(userName, password, address, email, mobileNumber);
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
	}
	@Override
	public int hashCode() {
		return Objects.hash(driverId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return driverId == other.driverId;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getAddress()="
				+ getAddress() + ", getEmail()=" + getEmail() + ", getMobileNumber()=" + getMobileNumber() + "]";
	}
	
	public Driver() {
    }
	
	

}
