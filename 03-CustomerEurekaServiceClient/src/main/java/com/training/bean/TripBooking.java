package com.training.bean;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name="bookingdetailss")
public class TripBooking {

	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_seq"
            )
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "booking_seq",
            allocationSize = 1
            )
	private int tripBookingId;
	@OneToOne
	
	private Customer customer;
	@ManyToOne
	
	private Driver driver;
	@Column
	private String fromLocation;
	@Column
	private String toLocation;
	@Column
	private LocalDateTime fromDateTime;
	@Column
	private LocalDateTime toDateTime;
	@Column
	private String status;
	@Column
	private float distanceInKm;
	@Column
	private float bill;
	
	
	
	
	
	public TripBooking(int tripBookingId, Customer customer, Driver driver, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, String status, float distanceInKm, float bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	
	
	public TripBooking(Customer customer, Driver driver, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, String status, float distanceInKm, float bill) {
		super();
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	


	public TripBooking(int tripBookingId) {
		super();
		this.tripBookingId = tripBookingId;
	}
	
	


	public TripBooking() {
		super();
	}


	public int getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	
	
	
	
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customer=" + customer + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(tripBookingId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripBooking other = (TripBooking) obj;
		return tripBookingId == other.tripBookingId;
	}
	
	

}
