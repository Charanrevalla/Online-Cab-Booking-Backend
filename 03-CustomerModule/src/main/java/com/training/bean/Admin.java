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
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_seq"
            )
    @SequenceGenerator(
            name = "admin_seq",
            sequenceName = "admin_seq",
            allocationSize = 1
            )
	
	private int adminId;
	@ManyToOne
	private User user;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Admin(int adminId, User user) {
		super();
		this.adminId = adminId;
		this.user = user;
	}
	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}
	public Admin() {
		super();
	}
	public Admin(User user) {
		super();
		this.user = user;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + user + "]";
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
