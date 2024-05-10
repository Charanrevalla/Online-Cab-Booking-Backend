package com.training.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.training.CustomerAdminResponse.CustomerAddByAdminResponse;
import com.training.CustomerAdminResponse.CustomerDeleteResponse;
import com.training.CustomerTripResponse.TripResponse;
import com.training.bean.Cab;
import com.training.bean.Customer;
import com.training.bean.TripBooking;
import com.training.bokkingresponse.CancelBookingResponse;
import com.training.bokkingresponse.CustomerBookingResponse;
import com.training.response.CabAddResponse;

import jakarta.ws.rs.HttpMethod;

@RestController
@RequestMapping("Customer")
public class CustomerInvokerController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	
	//Customer Operations 
	//1.Customer Regestration
	
	
	//add customer
	@PostMapping(value="/Registration")
public ResponseEntity<CustomerAddByAdminResponse> f8(@RequestBody Customer customer){
String url="http://03-CUSTOMERMODULE/customer/insert";
Customer d2=this.restTemplate.postForObject(url, customer, Customer.class);
CustomerAddByAdminResponse response= new CustomerAddByAdminResponse();
response.setStatusCode(200);
response.setMessage("Customer Registration is Sucessfully Done");
response.setCustomer(d2);
return ResponseEntity.ok(response);
		
}
	
	//2.Update a Customer
	@PutMapping(value = "/updatecustomer")
	public ResponseEntity<Customer> fan(@RequestBody Customer customer) {
	    String url = "http://03-CUSTOMERMODULE/customer/update";
	    try {
	        // Send a PUT request to update the customer
	        restTemplate.put(url, customer);
	        return ResponseEntity.ok(customer);
	    } catch (HttpClientErrorException.NotFound ex) {
	        // Handle case where customer is not found
	        return ResponseEntity.notFound().build();
	    } catch (RestClientException ex) {
	        // Handle other RestClientExceptions, such as connection errors
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	//3.Delete a customer optional 
	
	@DeleteMapping("delete/{customerId}")
	public ResponseEntity<CustomerDeleteResponse> deleteCuustomer(@PathVariable int customerId){
	    String url = "http://03-CUSTOMERMODULE/customer/delete/" + customerId;
	    restTemplate.delete(url);
	    CustomerDeleteResponse response=new CustomerDeleteResponse();
	    
	    response.setStatusCode(200); 
	    response.setMessage("Customer Deleted successfully");
	    return ResponseEntity.ok(response);
	}
// 4.customer view their profile optional
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
	    String url = "http://03-CUSTOMERMODULE/customer/" + customerId;
	    try {
	        Customer customer = restTemplate.getForObject(url, Customer.class);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (HttpClientErrorException.NotFound ex) {
	        return ResponseEntity.notFound().build();
	    } catch (RestClientException ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	
	
	//CustomerCabOperations on cabs //1.view all cabs
//2.
	
	@GetMapping("/viewCabs")
	public ResponseEntity<List<Cab>> getAllCabs() {
	    String url = "http://03-CUSTOMERMODULE/cabs/all";
	    Cab[] cabsArray = restTemplate.getForObject(url, Cab[].class);
	    
	    if (cabsArray != null) {
	        List<Cab> cabs = Arrays.asList(cabsArray);
	        return ResponseEntity.ok(cabs);
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
	    }
	}
	//Cab can be Book by cabId
	@GetMapping("/getCabById/{cabId}")
	public ResponseEntity<CabAddResponse> getCabById(@PathVariable int cabId) {
	    String url = "http://03-CUSTOMERMODULE/cabs/" + cabId;
	    Cab cab = restTemplate.getForObject(url, Cab.class);
	    CabAddResponse response = new CabAddResponse();
	    response.setStatusCode(200);
		
		response.setCab(cab);
		return ResponseEntity.ok(response);
	}
	// Create a book For Customer
	
	@PostMapping("/Booking")
	public ResponseEntity<TripBooking> createTripForCustomer(@RequestBody TripBooking tripBooking) {
	    // Assuming TripRequest contains necessary information for creating a trip

	    // Construct the URL for the trip creation endpoint in the admin module
	    String url = "http://03-CUSTOMERMODULE/Trips/createtrip";

	    // Send a POST request to the specified URL with the tripRequest object as the request body
	    TripBooking tripResponse = restTemplate.postForObject(url, tripBooking, TripBooking.class);

	    // Prepare and return the response entity
	    return ResponseEntity.ok(tripResponse);
	}
	
	
	//Cancel a Booking 
	

	@DeleteMapping("/cancel/{tripBookingId}")
	public ResponseEntity<CancelBookingResponse> cancelBooking(@PathVariable int tripBookingId) {
	    String url = "http://03-CUSTOMERMODULE/Trips/cancel/" + tripBookingId;
	    
	    restTemplate.delete(url);
	  
	   
	    CancelBookingResponse response = new CancelBookingResponse();
	    response.setStatusCode(200); 
	    response.setMessage("Booking canceled by Customer successfully completed"); 
	    return ResponseEntity.ok(response);
	}
	
	//Customer Viewing Booking details
	

	@GetMapping("/viewbook/{customerId}")
	public ResponseEntity<CustomerBookingResponse> getCustomerId(@PathVariable int customerId) {
	    String url = "http://03-CUSTOMERMODULE/Trips/" + customerId;
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
	
	
	