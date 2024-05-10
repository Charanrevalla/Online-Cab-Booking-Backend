package com.training.CustomerAdminResponse;

import com.training.bean.Customer;

public class CustomerDeleteResponse {
	

		private int statusCode;
		private String message;
		private Customer customer;
		
		public int getStatusCode() {
			return statusCode;
			
		}
		
		public void setStatusCode(int statusCode) {
			
			this.statusCode=statusCode;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message=message;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
		this.customer=customer;
		}

		
		
	}
		
		









