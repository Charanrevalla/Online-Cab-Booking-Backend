package com.training.controller;

import com.training.bean.Cab;

import com.training.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabs")
public class CabControllerImpl {

    @Autowired
    private CabService cabService;
   
   

    @PostMapping("/insert")
    public Cab insertCab(@RequestBody Cab cab) {
        return cabService.insertCab(cab);
    }

    @DeleteMapping("/delete")
    public String deleteCab(@RequestBody Cab cab) {
        return cabService.deleteCab(cab);
    }

    @PutMapping("/update")
    public Cab updateCab(@RequestBody Cab cab) {
        return cabService.updateCab(cab);
    }

    @GetMapping("/all")
    public List<Cab> getAllCabs() {
        return cabService.getAllCabs();
    }

    @GetMapping("/{cabId}")
    public Cab getCabById(@PathVariable int cabId) {
        return cabService.getCabById(cabId);
    }

    
    @GetMapping("/type/{carType}")
    public ResponseEntity<List<Cab>> getCabsByType(@PathVariable("carType") String carType) {
        List<Cab> cabs = cabService.getByCabsType(carType);
        return new ResponseEntity<>(cabs, HttpStatus.OK);
    }
}

