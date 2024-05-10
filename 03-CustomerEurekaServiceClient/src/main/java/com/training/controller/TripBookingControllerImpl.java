package com.training.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.TripBooking;
import com.training.service.TripBookingService;

@RestController
@RequestMapping("Trips")
public class TripBookingControllerImpl {
	@Autowired
    private TripBookingService tripBookingService;

    @PostMapping(value="/createtrip")
    public ResponseEntity<TripBooking> createTripBooking(@RequestBody TripBooking tripBooking) {
        TripBooking createdTrip = tripBookingService.insertTripBooking(tripBooking);
        return new ResponseEntity<>(createdTrip, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TripBooking> updateTripBooking(@PathVariable("id") int tripBookingId, @RequestBody TripBooking tripBooking) {
        TripBooking updatedTrip = tripBookingService.updateTripBooking(tripBookingId, tripBooking);
        if (updatedTrip != null) {
            return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/cancel/{tripBookingId}")
    public ResponseEntity<String> deleteTripBooking(@PathVariable int tripBookingId) {
        String message = tripBookingService.deleteTripBooking(tripBookingId);
        HttpStatus status = message.startsWith("TripBooking Deleted") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(message, status);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<TripBooking>> getAllTripsForCustomer(@PathVariable("customerId") int customerId) {
        List<TripBooking> customerTrips = tripBookingService.getAllTripsForCustomer(customerId);
        if (customerTrips.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerTrips, HttpStatus.OK);
        }
    }

    @GetMapping("/calculatebill/{customerId}")
    public ResponseEntity<TripBooking> calculateBill(@PathVariable("customerId") int customerId) {
        TripBooking totalBillTrip = tripBookingService.calculateBill(customerId);
        if (totalBillTrip == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(totalBillTrip);
        }
    }

    @GetMapping("/customerss")
    public List<TripBooking> getTripsForCustomerWithinDateRange(@RequestBody CustomerRangeRequest request){     
    int  customerId=request.getCustomerId();
    LocalDate fromDate=request.getFromDate();
    LocalDate toDate=request.getToDate();
            
        
        

        List<TripBooking> trips = tripBookingService.getAllTripsForDays(customerId, fromDate, toDate);
        return trips;
    }
}
