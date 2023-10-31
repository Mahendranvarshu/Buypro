package com.mahitech.Buypro.Services;

import com.mahitech.Buypro.Data.Customers;
import com.mahitech.Buypro.Interfaces.CustomerInterface;
import com.mahitech.Buypro.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService  implements CustomerInterface {

    @Autowired
    CustomerRepo customerRepo;





    public ResponseEntity<String> save(Customers customers) {

        customers.setCreateby(LocalDateTime.now());
        customers.setStatus(true);

        customerRepo.save(customers);
        return new ResponseEntity<>( "Creating Customer successfully", HttpStatus.CREATED);
    }

    public Customers get(Integer id) {
        return  customerRepo.findByEntityId(id);


    }

    public List<Customers> getall( ) {

        return customerRepo.findAll();
    }

    public ResponseEntity<String> delete(Integer id){
        customerRepo.deleteById(id);
        return new ResponseEntity<>("Delete Customer Succesfully",HttpStatus.OK);
    }


}
