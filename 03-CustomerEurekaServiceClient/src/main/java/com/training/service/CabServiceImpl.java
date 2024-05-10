package com.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Cab;
import com.training.bean.Customer;
import com.training.dao.CabDAO;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	CabDAO cabDAO;
	
	@Override
    public Cab insertCab(Cab cab) 
    {
    	Cab c1=this.cabDAO.save(cab);
    	return c1;
    
    }
 @Override
    	    public  String deleteCab(Cab cab) {
    	    	
    	    	this.cabDAO.delete(cab);
    	    	return "Cab is deleted sucessfully";
    	    }
    	    
    	    @Override
    	    public Cab updateCab(Cab cab) {
    	    	Cab c2=this.cabDAO.save(cab);
    	    	return c2;
    	    }
    	    
	
	
    	    public List<Cab> getByCabsType(String carType) {
    	        List<Cab> allCabs = cabDAO.findAll();
    	        List<Cab> filteredCabs = new ArrayList<>();
    	        for (Cab cab : allCabs) {
    	            if (carType != null && carType.equals(cab.getCarType())) {
    	                filteredCabs.add(cab);
    	            }
    	        }
    	        return filteredCabs;
    	    }
    	
	
	
	@Override
    public List<Cab> getAllCabs() {
        return cabDAO.findAll();
    }

    @Override
    public Cab getCabById(int cabId) {
        return cabDAO.findById(cabId).orElse(null);
    }
}