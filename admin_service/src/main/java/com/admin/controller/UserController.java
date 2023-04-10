package com.admin.controller;

import com.admin.pojo.User;
import com.admin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> getAllUser()
    {
        try
        {
            return userServiceImpl.findAllUsers();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
