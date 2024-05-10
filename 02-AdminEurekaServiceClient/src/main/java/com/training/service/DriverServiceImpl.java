package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.training.bean.Driver;
import com.training.dao.DriverDAO;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	DriverDAO driverDAO;
	
	@Override
	public Driver insertDriver(Driver driver) {
		
		Driver d1= this.driverDAO.save(driver);
		return d1;
	}

	@Override
	public Driver updateDriver(Driver driver) {
		Driver d2=this.driverDAO.save(driver);
		return d2;
	}

	@Override
	public String deleteDriver(Driver driver) {

        this.driverDAO.delete(driver);
	    
	    return "Driver Deleted !!!!";
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> allDrivers=this.driverDAO.findAll();
		return allDrivers;
	}
	

	@Override
	public Driver getDriverById(int driverId) {
		Optional<Driver> driver=this.driverDAO.findById(driverId);
		if(driver.isPresent()) {
			return driver.get();
		}
			return null;
		}

}
