package com.training.controller;

import com.training.bean.Admin;
import com.training.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestControllerImpl implements AdminRestController {

    private  AdminService adminService;

    @Autowired
    public AdminRestControllerImpl(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Admin insertAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }


    @Override
    public String updateAdmin(int adminId) {
        return adminService.updateAdmin(adminId);
    }

    @Override
    public String deleteAdmin(int adminId) {
        return adminService.deleteAdmin(adminId);
    }
}