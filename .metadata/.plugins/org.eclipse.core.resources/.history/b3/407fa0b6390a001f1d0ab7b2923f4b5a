package com.training.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.TripBooking;
import com.training.dao.DriverDAO;
import com.training.dao.TripBookingDAO;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripBookingDAO tripBookingDAO;
	@Autowired
	private DriverDAO driverDAO;

	/*
	 * @Override public TripBooking insertTripBooking(TripBooking tripBooking) {
	 * TripBooking newTrip = null; try { // Calculate the bill for the trip float
	 * distanceInKm = tripBooking.getDistanceInKm(); float perKmRate =
	 * tripBooking.getDriver().getCab().getPerKmRate(); float tripBill =
	 * distanceInKm * perKmRate;
	 * 
	 * // Set the calculated bill to the trip booking tripBooking.setBill(tripBill);
	 * 
	 * // Save the trip booking to the database newTrip =
	 * this.tripBookingDAO.save(tripBooking);
	 * ConsoleUtil.printCaption("TripBooking Add Completed"); } catch (Exception e)
	 * { // Handle exceptions } ConsoleUtil.printData(newTrip); return newTrip; }
	 */

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		/*
		 * Driver driver = tripBooking.getDriver();
		 * 
		 * float perKmRate = driver.getDriverId(); ConsoleUtil.printData(perKmRate);
		 * float distanceInKm = tripBooking.getDistanceInKm();
		 * ConsoleUtil.printData(distanceInKm); float bill = perKmRate * distanceInKm;
		 * ConsoleUtil.printData(bill); tripBooking.setBill(bill);
		 */

		// Save the trip booking
		TripBooking savedTrip = this.tripBookingDAO.save(tripBooking);
		return savedTrip;
	}

	@Override
	public TripBooking updateTripBooking(int tripBookingId, TripBooking tripBooking) {
		Optional<TripBooking> optionalTripBooking = tripBookingDAO.findById(tripBookingId);

		if (optionalTripBooking.isPresent()) {
			tripBooking.setTripBookingId(tripBookingId);
			return tripBookingDAO.save(tripBooking);
		} else {
			return null; // Or you can throw an exception if needed
		}
	}

	@Override
	public String deleteTripBooking(int tripBookingId) {
		Optional<TripBooking> optionalTripBooking = tripBookingDAO.findById(tripBookingId);

		if (optionalTripBooking.isPresent()) {
			tripBookingDAO.deleteById(tripBookingId);
			return "TripBooking Deleted";
		} else {
			return "TripBooking with ID " + tripBookingId + " does not exist";
		}
	}

	@Override
	public List<TripBooking> getAllTripsForCustomer(int customerId) {
		List<TripBooking> customerTrips = new ArrayList<>();
		List<TripBooking> allTripBookings = tripBookingDAO.findAll();
		for (TripBooking tripBooking : allTripBookings) {
			if (tripBooking.getCustomer() != null && tripBooking.getCustomer().getCustomerId() == customerId) {
				customerTrips.add(tripBooking);
			}
		}
		return customerTrips;
	}
	/*
	 * @Override public List<TripBooking> getTripsCabwise() { return
	 * tripBookingDAO.getTripsCabwise(); }
	 * 
	 * @Override public List<TripBooking> getTripsCustomerWise() { return
	 * tripBookingDAO.getTripsCustomerWise(); }
	 * 
	 * @Override public List<TripBooking> getTripsDatewise() { return
	 * tripBookingDAO.getTripsDatewise(); }
	 */

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDate fromDate, LocalDate toDate) {
		List<TripBooking> allBookings = this.tripBookingDAO.findAll();
		List<TripBooking> bookingsWithinDateRange = new ArrayList<>();
LocalDateTime fromTime=fromDate.atStartOfDay();
LocalDateTime toTime=toDate.atStartOfDay();
		for (TripBooking trip : allBookings) {
			if (trip.getCustomer().getCustomerId() == customerId && trip.getFromDateTime().isAfter(fromTime)
					&& trip.getToDateTime().isBefore(toTime)) {
				bookingsWithinDateRange.add(trip);
			}
		}

		return bookingsWithinDateRange;
	}

	@Override
	public TripBooking calculateBill(int customerId) {
		// Fetch all trip bookings
		List<TripBooking> allTrips = tripBookingDAO.findAll();

		// Calculate the total bill for the specified customer
		float totalBill = 0;
		for (TripBooking trip : allTrips) {
			if (trip.getCustomer() != null && trip.getCustomer().getCustomerId() == customerId) {
				totalBill += trip.getBill();
			}
		}

		// Create a new TripBooking object to represent the total bill
		TripBooking totalBillTrip = new TripBooking();
		totalBillTrip.setBill(totalBill);

		return totalBillTrip;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		List<TripBooking> allBookings = this.tripBookingDAO.findAll();
		List<TripBooking> bookingsbyCustomers = new ArrayList<>();
		for (TripBooking t : allBookings) {
			if (t.getCustomer().getCustomerId() == customerId) {
				bookingsbyCustomers.add(t);
			}

		}
		return bookingsbyCustomers;
	}




}