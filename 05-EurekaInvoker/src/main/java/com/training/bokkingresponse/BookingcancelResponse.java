package com.training.bokkingresponse;

import com.training.bean.TripBooking;

public class BookingcancelResponse {

	

			private int statusCode;
			private String message;
			private TripBooking tripBooking;
			
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
			
			public TripBooking gettrip() {
				return tripBooking;
			}
			public void settrip(TripBooking tripBooking) {
			this.tripBooking=tripBooking;
			}

			
			}
			
			





