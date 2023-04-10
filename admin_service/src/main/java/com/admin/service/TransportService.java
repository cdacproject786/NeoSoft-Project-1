package com.admin.service;

import com.admin.IService.ItransportService;
import com.admin.exterservice.TransporterServive;
import com.admin.pojo.TransportDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService implements ItransportService {

    @Autowired
    TransporterServive transporterServive;

    public ResponseEntity<?> getDetails()
    {
        return transporterServive.getAllUsers();
    }

    public ResponseEntity<?> getAllOrders()
    {
        return transporterServive.getAllOrders();
    }
}
