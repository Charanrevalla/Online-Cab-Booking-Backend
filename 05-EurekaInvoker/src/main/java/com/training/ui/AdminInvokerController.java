package com.training.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.DocFlavor.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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
import org.springframework.web.service.annotation.PatchExchange;

import com.google.common.net.HttpHeaders;
import com.training.CustomerAdminResponse.CustomerAddByAdminResponse;
import com.training.CustomerAdminResponse.CustomerDeleteResponse;
import com.training.CustomerTripResponse.TripResponse;
import com.training.bean.Cab;
import com.training.bean.Customer;
import com.training.bean.Driver;
import com.training.bean.TripBooking;
import com.training.bokkingresponse.CancelBookingResponse;
import com.training.bokkingresponse.CustomerBookingResponse;
import com.training.driverResponse.DriverAddResponse;
import com.training.driverResponse.DriverDeleteResponse;
import com.training.driverResponse.DriverGetResponse;
import com.training.driverResponse.DriverUpdateResponse;
import com.training.response.CabAddResponse;
import com.training.response.CabDeleteResponse;
import com.training.response.CabUpdateResponse;

import jakarta.annotation.Resource;
import jakarta.ws.rs.HttpMethod;

@RestController
@RequestMapping("/Admin")
public class AdminInvokerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	//cars all operations done;
	//Add a Cab
	@PostMapping("/addCab")
	public ResponseEntity<CabAddResponse> f1(@RequestBody Cab cab){
	
	String url="http://02-ADMINMODULE/cabs/insert";
	Cab c1=this.restTemplate.postForObject(url, cab, Cab.class);
	CabAddResponse response = new CabAddResponse();
	response.setStatusCode(200);
	response.setMessage("Cab Added sycessfully");
	response.setCab(c1);
	return ResponseEntity.ok(response);
	

}
	
	@DeleteMapping("/deletethecab/{cabId}")
    public ResponseEntity<CabDeleteResponse> deleteCab(@PathVariable int cabId) {
        String url = "http://02-ADMINMODULE/cabs/delete/" + cabId;
        
        // Send a DELETE request to the specified URL
        restTemplate.delete(url);
      
        // Prepare and return the response entity
        CabDeleteResponse response = new CabDeleteResponse();
        response.setStatusCode(200); // Set appropriate status code
        response.setMessage("Cab deleted successfully"); // Set appropriate message
        return ResponseEntity.ok(response);
    }

	@PutMapping("/update")
	public ResponseEntity<CabUpdateResponse> updateCab(@RequestBody Cab cab) {
	    String url = "http://02-ADMINMODULE/cabs/update";
	    
	    
	    restTemplate.put(url, cab);
	  
	    
	    CabUpdateResponse response = new CabUpdateResponse();
	    response.setStatusCode(200); 
	    response.setMessage("Cab updated successfully");
	    return ResponseEntity.ok(response);
	}

	


	@GetMapping("/getAllCabs")
	public ResponseEntity<List<Cab>> getAllCabs() {
	    String url = "http://02-ADMINMODULE/cabs/all";
	    Cab[] cabsArray = restTemplate.getForObject(url, Cab[].class);
	    
	    if (cabsArray != null) {
	        List<Cab> cabs = Arrays.asList(cabsArray);
	        return ResponseEntity.ok(cabs);
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
	    }
	}

	
	@GetMapping("/getCabById/{cabId}")
	public ResponseEntity<CabAddResponse> getCabById(@PathVariable int cabId) {
	    String url = "http://02-ADMINMODULE/cabs/" + cabId;
	    Cab cab = restTemplate.getForObject(url, Cab.class);
	    CabAddResponse response = new CabAddResponse();
	    response.setStatusCode(200);
	    response.setMessage("Cab with" +cabId+ "Reterved sucessfully"); // Set appropriate message
		
		response.setCab(cab);
		return ResponseEntity.ok(response);
	}

	//Admin Driver Operations
	
	//Add a Driver
		@PostMapping("/addDriver")
		public ResponseEntity<DriverAddResponse> f1(@RequestBody Driver driver){
		
		String url="http://02-ADMINMODULE/drivers/add";
		Driver d1=this.restTemplate.postForObject(url, driver, Driver.class);
DriverAddResponse response = new DriverAddResponse();
		response.setStatusCode(200);
		response.setMessage("Driver Added sucessfully");
		response.setDriver(d1);
		return ResponseEntity.ok(response);
		

	}
	//Get a driver
		
		@GetMapping("/getAllDrivers")
		public ResponseEntity<List<Driver>> getAllDrivers() {
		    String url = "http://02-ADMINMODULE/drivers/all";
		    Driver[] driversArray = restTemplate.getForObject(url, Driver[].class);
		    
		    if (driversArray != null) {
		      
				List<Driver> drivers = Arrays.asList(driversArray);
		        return ResponseEntity.ok(drivers);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
		    }
		}
		
		//delete driver
		@DeleteMapping("/deleting/{driverId}")
		public ResponseEntity<DriverDeleteResponse> f20(@PathVariable int driverId){
		    String url = "http://02-ADMINMODULE/drivers/driverdelete/" +driverId;
		    restTemplate.delete(url);
		    DriverDeleteResponse response=new DriverDeleteResponse();
		    response.setStatusCode(200);
		    response.setMessage("Driver deleted sucessfully");
		    return ResponseEntity.ok(response);

		}
		
		
		
		
		
		//update a driver
		@PutMapping("/updatedriver")
		public ResponseEntity<DriverUpdateResponse> updatetheDriver(@RequestBody Driver driver){
		    String url = "http://02-ADMINMODULE/drivers/update";
		    restTemplate.put(url, driver);
		    DriverUpdateResponse response=new DriverUpdateResponse();
		    response.setStatusCode(200);
		    response.setMessage("Driver updated sucessfully");
		    return ResponseEntity.ok(response);
		}
		
		

		
		
		
		
		
		
		
		
		//Get a Driver By id
		@GetMapping("/getdriverById/{driverId}")
		public ResponseEntity<DriverGetResponse> getDriverById(@PathVariable int driverId) {
		    String url = "http://02-ADMINMODULE/drivers/" + driverId;
		    Driver driver = restTemplate.getForObject(url, Driver.class);
		    DriverGetResponse response = new DriverGetResponse();
		    response.setStatusCode(200);
			response.setMessage("Driver reterived sucessfully");
			
			response.setDriver(driver);
			return ResponseEntity.ok(response);
		}
		
		//booking admin can view booking cancel bookings 
		
		
		@GetMapping("/viewbook/{customerId}")
		public ResponseEntity<CustomerBookingResponse> getCustomerById(@PathVariable int customerId) {
		    String url = "http://02-ADMINMODULE/Trips/" + customerId;
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

		

		

		@DeleteMapping("/cancel/{tripBookingId}")
		public ResponseEntity<CancelBookingResponse> cancelBooking(@PathVariable int tripBookingId) {
		    String url = "http://02-ADMINMODULE/Trips/cancel/" + tripBookingId;
		    
		    restTemplate.delete(url);
		  
		   
		    CancelBookingResponse response = new CancelBookingResponse();
		    response.setStatusCode(200); 
		    response.setMessage("Booking canceled successfully"); 
		    return ResponseEntity.ok(response);
		}
		
		
		//customer mappings :
		

		
		
		//add customer
		@PostMapping(value="/AddcustomerByAdmin")
public ResponseEntity<CustomerAddByAdminResponse> f8(@RequestBody Customer customer){
	String url="http://02-ADMINMODULE/customer/insert";
	Customer d2=this.restTemplate.postForObject(url, customer, Customer.class);
	CustomerAddByAdminResponse response= new CustomerAddByAdminResponse();
	response.setStatusCode(200);
	response.setMessage("Customer added sucessfully by admin");
	response.setCustomer(d2);
	return ResponseEntity.ok(response);
			
}

		
		
		//view customer
		@GetMapping("/getAllCustomers")
		public ResponseEntity<List<Customer>> getAllCustomers() {
		    String url = "http://02-ADMINMODULE/customer/getAll";
		    Customer[] customersArray = restTemplate.getForObject(url, Customer[].class);
		    
		    if (customersArray != null) {
		        List<Customer> customers = Arrays.asList(customersArray);
		        return ResponseEntity.ok(customers);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
		    }
		}
		@GetMapping("reterivecustomer/{customerId}")
		public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
		    String url = "http://02-ADMINMODULE/customer/" + customerId;
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

		@PutMapping(value = "/updatethecustomer")
		public ResponseEntity<Customer> fan(@RequestBody Customer customer) {
		    String url = "http://02-ADMINMODULE/customer/update";
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

		@DeleteMapping("deletetheCustomer/{customerId}")
		public ResponseEntity<CustomerDeleteResponse> deleteCuustomer(@PathVariable int customerId){
		    String url = "http://02-ADMINMODULE/customer/delete/" + customerId;
		    restTemplate.delete(url);
		    CustomerDeleteResponse response=new CustomerDeleteResponse();
		    
		    response.setStatusCode(200); 
		    response.setMessage("Customer Deleted successfully");
		    return ResponseEntity.ok(response);
		}
		
		
           
		}



		

