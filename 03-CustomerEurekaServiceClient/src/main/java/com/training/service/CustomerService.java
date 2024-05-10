package com.training.service;


import java.util.List;

import com.training.bean.Customer;

	public interface CustomerService {

		Customer insertCustomer(Customer customer);
		
		Customer updateCustomer(Customer customer);
		
		String deleteCustomer(int customerId);
		
		List<Customer> getAllCustomers();
		Customer getCustomer(int customerId);
		
		
}