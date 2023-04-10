package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin)
    {
        try {
            return  adminService.insertAdmin(admin);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/demo")
    public String demo()
    {
        return "Message coming from secure endpoint";
    }

    @GetMapping("/getadmins")
    public ResponseEntity<?> getAllAdmins()
    {
        try
        {
            List<Admin> admins =   adminService.findAllAdmins();
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
