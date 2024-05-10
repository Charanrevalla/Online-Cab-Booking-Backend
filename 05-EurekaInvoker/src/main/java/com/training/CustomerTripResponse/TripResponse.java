package com.training.CustomerTripResponse;


import com.training.bean.TripBooking;

public class TripResponse {

    private int statusCode;
    private String message;
    private TripBooking tripBooking;

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
    
    public TripBooking getTrip() {
        return tripBooking;
    }

    public void setTrip(TripBooking tripBooking) {
        this.tripBooking = tripBooking;
    }
}


