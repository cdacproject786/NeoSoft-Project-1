package com.admin.service;

import com.admin.exterservice.UserService;
import com.admin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl {

    @Autowired
    UserService userService;

    public List<User> findAllUsers()
    {
       return userService.getAll();
    }
}
