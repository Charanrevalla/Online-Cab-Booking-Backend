package com.training.response;

import com.training.bean.Cab;

public class CabGetAllResponse {

	
	
	    private int statusCode;
	    private String message;
	    private Cab cab;

	    public int getStatusCode() {
	        return statusCode;
	    }

	    public void setStatusCode(int statusCode) {
	        this.statusCode = statusCode;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	    
	    public Cab getCab() {
			return cab;
		}
		

		
	}


