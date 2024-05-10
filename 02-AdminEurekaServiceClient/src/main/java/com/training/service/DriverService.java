package com.training.service;

import java.util.List;

import com.training.bean.Driver;



public interface DriverService {
	
	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
    String deleteDriver(Driver driver);
    List<Driver> getAllDrivers();
    Driver getDriverById(int driverId);

}
