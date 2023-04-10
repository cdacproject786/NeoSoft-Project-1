package com.admin.service;

import com.admin.IService.IServiceProviderService;
import com.admin.exterservice.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderServiceImpl implements IServiceProviderService {

    @Autowired
    ServiceProviderService serviceProviderService;

    public ResponseEntity<?> getAllServiceProviders()
    {
       return serviceProviderService.getAllServiceProvider();
    }
}
