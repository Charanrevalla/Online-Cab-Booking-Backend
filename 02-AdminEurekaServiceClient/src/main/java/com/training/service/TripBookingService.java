package com.training.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.training.bean.TripBooking;

public interface TripBookingService {
	TripBooking insertTripBooking(TripBooking tripBooking);
    TripBooking updateTripBooking(int tripBookingId, TripBooking tripBooking);


    String deleteTripBooking(int tripBookingId); // Accept trip booking ID instead of object
    List<TripBooking> getAllTripsForCustomer(int customerId);
    TripBooking calculateBill(int customerId);
    List<TripBooking> getAllTripsForDays(int customerId, LocalDate fromDate, LocalDate toDate);
    List<TripBooking> getAllTrips(int customerId);
}


	
	/*List<TripBooking> getTripsCabwise();
		
	List<TripBooking> getTripsCustomerwise();
	
	List<TripBooking> getTripsDatewise();*/
	
	

