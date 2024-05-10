package com.training.bean;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="adminUser")
public class Admin  extends AbstractUser{
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Admin_seq1"
            )
    @SequenceGenerator(
            name = "Admin_seq1",
            sequenceName = "Administator_seq",
            allocationSize = 1
            )
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
