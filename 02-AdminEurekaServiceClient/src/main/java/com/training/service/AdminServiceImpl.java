package com.training.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Admin;
import com.training.bean.TripBooking;
import com.training.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		Admin a1=this.adminDAO.save(admin);
		return a1;
	}

	@Override
	public String updateAdmin(int adminId) {
	    Optional<Admin> adminOptional = adminDAO.findById(adminId);
	    if (adminOptional.isPresent()) {
	        Admin adminToUpdate = adminOptional.get();
	        
	        adminDAO.save(adminToUpdate);
	        return "Admin with ID " + adminId + " updated successfully";
	    } else {
	        return "Admin with ID " + adminId + " does not exist";
	    }
	}

	
	@Override
    public String deleteAdmin(int adminId) {
        
        if (adminDAO.existsById(adminId)) {
            adminDAO.deleteById(adminId);
            return "Admin deleted successfully";
        } else {
            
            return "Admin with ID " + adminId + " does not exist";
        }
    }
/*
	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		List<TripBooking> allBookings=this.getAllTrips(customerId);
		return allBookings;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		List<TripBooking> allTripBookings=this.getTripsCabwise();
		return allTripBookings;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> allTripBookings=this.getTripsCustomerwise();
		return allTripBookings;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		List<TripBooking> allTripBookings=this.getTripsDatewise();
		return allTripBookings;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		List<TripBooking> allTripBookings=this.getAllTripsForDays(customerId, fromDate, toDate);
		return allTripBookings;
	}*/

	
	
	

}