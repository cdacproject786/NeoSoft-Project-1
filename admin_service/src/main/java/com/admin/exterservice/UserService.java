package com.admin.exterservice;

import com.admin.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserService {

    @GetMapping("/user/getAllUsers")
    public List<User> getAll();
}
