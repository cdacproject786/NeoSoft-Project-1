package com.admin.IService;

import org.springframework.http.ResponseEntity;

public interface ItransportService {

    public ResponseEntity<?> getDetails();
    public ResponseEntity<?> getAllOrders();
}
