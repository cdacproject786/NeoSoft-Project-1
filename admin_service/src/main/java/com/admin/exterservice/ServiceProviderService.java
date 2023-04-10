package com.admin.exterservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PACKING-SERVICE")
public interface ServiceProviderService {

    @GetMapping("AllServiceProvider")
    public ResponseEntity<?> getAllServiceProvider();
}
