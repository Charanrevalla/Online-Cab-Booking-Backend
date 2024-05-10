package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Driver;

@Repository
public interface DriverDAO extends JpaRepository<Driver, Integer>{

}
