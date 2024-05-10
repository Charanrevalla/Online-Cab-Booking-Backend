package com.training.driverResponse;

import com.training.bean.Driver;

public class DriverAddResponse {


		private int statusCode;
		private String message;
		private Driver driver;
		
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
		
		public Driver getDriver() {
			return driver;
		}
		public void setDriver(Driver driver) {
		this.driver=driver;
		}

		
		}
		
		



