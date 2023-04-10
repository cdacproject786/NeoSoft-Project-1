package com.authservice.IFeign;

import com.authservice.pojo.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ADMIN-SERVICE")
public interface AdminFeign {

    @PostMapping("/admin/register")
    public Admin registerAdmin(@RequestBody Admin admin);
}
