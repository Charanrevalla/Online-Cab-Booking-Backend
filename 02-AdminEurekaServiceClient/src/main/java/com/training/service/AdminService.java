package com.training.service;

import java.time.LocalDateTime;
import java.util.List;

import com.training.bean.Admin;
import com.training.bean.TripBooking;

public interface AdminService {
	
	Admin insertAdmin(Admin admin);
	
	String updateAdmin(int adminId); // Update admin details
    
	
	String deleteAdmin(int adminId);
}
	/*List<TripBooking> getAllTrips(int customerId);
	
	List<TripBooking> getTripsCabwise();
	
	List<TripBooking> getTripsCustomerwise();
	
	List<TripBooking> getTripsDatewise();
	
	List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);
*/