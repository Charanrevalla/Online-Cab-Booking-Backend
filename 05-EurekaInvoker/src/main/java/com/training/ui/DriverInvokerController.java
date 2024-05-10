package com.training.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.training.bean.TripBooking;
import com.training.bokkingresponse.CustomerBookingResponse;

@RestController
@RequestMapping("Driver")

public class DriverInvokerController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	

	@GetMapping("/viewbook/{customerId}")
	public ResponseEntity<CustomerBookingResponse> getCustomerId(@PathVariable int customerId) {
	    String url = "http://04-DRIVERMODULE/Trips/" + customerId;
	    try {
	        TripBooking[] tripBookings = restTemplate.getForObject(url, TripBooking[].class);
	        
	        if (tripBookings != null && tripBookings.length > 0) {
	            // Assuming you want to return the first trip booking if multiple are returned
	            TripBooking tripBooking = tripBookings[0];
	            CustomerBookingResponse response = new CustomerBookingResponse();
	            response.setStatusCode(200);
	            response.setMessage("Booking details");
	            response.settrip(tripBooking);
	            return ResponseEntity.ok(response);
	        } else {
	            // Handle case where no trips are found for the customer
	            CustomerBookingResponse response = new CustomerBookingResponse();
	            response.setStatusCode(404);
	            response.setMessage("No booking found for the customer");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (HttpClientErrorException.NotFound e) {
	        // Handle case where the requested resource is not found
	        CustomerBookingResponse response = new CustomerBookingResponse();
	        response.setStatusCode(404);
	        response.setMessage("No booking found for the customer");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    } catch (Exception e) {
	        // Handle any other exceptions that may occur
	        e.printStackTrace();
	        CustomerBookingResponse response = new CustomerBookingResponse();
	        response.setStatusCode(500);
	        response.setMessage("Internal Server Error");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	

}
