package com.mahitech.Buypro.Controllers;

import com.mahitech.Buypro.Data.Customers;
import com.mahitech.Buypro.Repo.CustomerRepo;

import com.mahitech.Buypro.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @Autowired
    CustomerRepo customerRepo;

    public Integer nameid = 0;





    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }



    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Customers customers)
    {
        return customerService.save(customers);
    }





    @GetMapping("get")
    public ResponseEntity<Customers> get() {
       Customers customers=customerService.get(Math.toIntExact(nameid));
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



    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customers customers ) {
        // Check if the username is already in use
        if (customerRepo.findByUsername(customers.getName()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");

        }

        customerRepo.save(customers);
        return ResponseEntity.ok("Registration successful");
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Customers customers) {
        Customers storedUser = customerRepo.findByUsername(customers.getName());

        if (storedUser == null) {
            return ResponseEntity.status(202).body("Incorrect password.");
        }

        if (!storedUser.getPassword().equals(customers.getPassword())) {
            return ResponseEntity.badRequest().body("Incorrect password.");
        }

        // In a secure setup, you would generate and return a secure token here.
        // For simplicity, returning a message.
        System.out.println(storedUser.getId());
        nameid=storedUser.getId();
        return ResponseEntity.ok("Login successful");
    }


    @GetMapping("user")
    public Integer getcustom() {

       return  nameid;
    }




}



