package com.mahitech.Buypro.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Order")
public class OrderController {

    @GetMapping("/api/data")
    public ResponseEntity<String> getData() {
        // Replace this with your actual data retrieval logic
        String data = "Hello from Spring Boot!";
        return ResponseEntity.ok(data);
    }
}
