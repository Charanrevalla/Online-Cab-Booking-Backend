package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
