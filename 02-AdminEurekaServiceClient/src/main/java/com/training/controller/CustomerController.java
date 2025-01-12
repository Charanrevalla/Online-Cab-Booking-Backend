package com.training.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

	import com.training.bean.Customer;
	import com.training.service.CustomerService;

	@RestController
	@RequestMapping("/customer")
	public class CustomerController {
	    @Autowired
	    private CustomerService customerService;

	    @PostMapping(value="insert")
	    public Customer insertCustomer(@RequestBody Customer customer) {
	        return customerService.insertCustomer(customer);
	    }
	    @DeleteMapping(value="delete/{customerId}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
	        String message = customerService.deleteCustomer(customerId);
	        return ResponseEntity.ok(message);
	    }

	    @PutMapping(value="update")
	    public Customer updateCustomer(@RequestBody Customer customer) {
	        return customerService.updateCustomer(customer);
	    }

	    @GetMapping(value="getAll")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }
	    @GetMapping("/{customerId}")
	    public Customer getCustomer(@PathVariable int customerId) {
	        return customerService.getCustomer(customerId);
	    }
	}
	

