package com.admin.service;

import com.admin.entity.Admin;
import com.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin insertAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }

    public List<Admin> findAllAdmins()
    {
       return  adminRepository.findAll();
    }

}
