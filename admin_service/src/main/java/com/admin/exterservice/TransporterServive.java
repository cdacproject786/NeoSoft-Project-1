package com.admin.exterservice;

import com.admin.pojo.TransportDetails;
import com.admin.pojo.TransportOrders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "TRANSPORT-SERVICE")
public interface TransporterServive {

   /* @PostMapping("/TransportRegister")
    public String Transportregister(@RequestBody TransportDetails transportDetails);

    @PostMapping("/TransportOrder")
    public String register (@RequestBody TransportOrders transportOrders);*/

    @GetMapping("/Transport/getAllUsers")
    public ResponseEntity<?> getAllUsers();

    @GetMapping("/Transport/getAllOrders")
    public ResponseEntity<?> getAllOrders();

}
