package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.TripBooking;

@Repository
public interface TripBookingDAO extends JpaRepository<TripBooking, Integer>{

}
