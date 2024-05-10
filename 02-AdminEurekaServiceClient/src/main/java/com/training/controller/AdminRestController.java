package com.training.controller;

import com.training.bean.Admin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminUser")
public interface AdminRestController {

    @PostMapping("/insert")
    Admin insertAdmin(@RequestBody Admin admin);

    @PutMapping("/{adminId}")
    String updateAdmin(@PathVariable int adminId);

    
    @DeleteMapping("/{adminId}")
    String deleteAdmin(@PathVariable int adminId);
}