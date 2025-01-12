package com.training.bean;

import java.util.Objects;

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
@Table(name="driver")
public class Driver {
	
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "driver_seq"
            )
    @SequenceGenerator(
            name = "driver_seq",
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
	@ManyToOne
	private User user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Driver(int driverId, String licenceNo, Cab cab, float rating, User user) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
		this.user = user;
	}
	public Driver(int driverId) {
		super();
		this.driverId = driverId;
	}
	public Driver(String licenceNo, Cab cab, float rating, User user) {
		super();
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
		this.user = user;
	}
	public Driver() {
		super();
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
				+ ", user=" + user + "]";
	}
	
	

}
