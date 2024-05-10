package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Cab;

@Repository
public interface CabDAO extends JpaRepository<Cab, Integer>{

}
