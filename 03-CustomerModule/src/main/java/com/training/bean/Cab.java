package com.training.bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="cab")
public class Cab {
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cab_seq"
            )
    @SequenceGenerator(
            name = "cab_seq",
            sequenceName = "cab_seq",
            allocationSize = 1
            )
	private int cabId;
	@Column
	private String carType;
	@Column
	private float perKmRate;
	
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	public Cab(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}
	public Cab(int cabId) {
		super();
		this.cabId = cabId;
	}
	public Cab(String carType, float perKmRate) {
		super();
		this.carType = carType;
		this.perKmRate = perKmRate;
	}
	public Cab() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(cabId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return cabId == other.cabId;
	}
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
	
	

}
