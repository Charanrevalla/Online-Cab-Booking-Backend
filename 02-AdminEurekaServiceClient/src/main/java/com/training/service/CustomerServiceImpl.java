package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.training.bean.Customer;
import com.training.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public Customer insertCustomer(Customer customer) {
	
		Customer c1=this.customerDAO.save(customer);
		return c1;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer c2=this.customerDAO.save(customer);
		return c2;
	}

	public String deleteCustomer(int customerId) {
        if (customerDAO.existsById(customerId)) {
            customerDAO.deleteById(customerId);
            return "Customer with ID " + customerId + " deleted successfully";
        } else {
            return "Customer with ID " + customerId + " does not exist";
        }
    }
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers=this.customerDAO.findAll();
		return allCustomers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Optional<Customer> cus=this.customerDAO.findById(customerId);
		if(cus.isPresent()) {
			return cus.get();
		}
			return null;
		}


	}


