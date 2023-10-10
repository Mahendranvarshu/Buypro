package com.mahitech.Buypro.Controllers;

import com.mahitech.Buypro.Data.Customers;
import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Customers customers)
    {
        return customerService.save(customers);
    }



    @GetMapping("get/{id}")
    public ResponseEntity<Customers> get(@PathVariable Integer id) {
       Customers customers=customerService.get(id);
        return ResponseEntity.ok(customers);
    }

   @GetMapping("getAll")
    public List<Customers> getAll() {

        return customerService.getall();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>  delete(@PathVariable Integer id){
        return customerService.delete(id);
    }





}



