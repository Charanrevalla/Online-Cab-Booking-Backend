package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer>{

}
