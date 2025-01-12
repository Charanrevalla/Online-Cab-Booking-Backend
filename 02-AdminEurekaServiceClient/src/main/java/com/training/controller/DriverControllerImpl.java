package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Driver;
import com.training.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverControllerImpl {

	@Autowired
	private DriverService driverService;

	@PostMapping("/add")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
		Driver newDriver = driverService.insertDriver(driver);
		return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
		Driver updatedDriver = driverService.updateDriver(driver);
		return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteDriver(@RequestBody Driver driver) {
		String message = driverService.deleteDriver(driver);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Driver>> getAllDrivers() {
		List<Driver> allDrivers = driverService.getAllDrivers();
		return new ResponseEntity<>(allDrivers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable("id") int driverId) {
		Driver driver = driverService.getDriverById(driverId);
		if (driver != null) {
			return new ResponseEntity<>(driver, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
