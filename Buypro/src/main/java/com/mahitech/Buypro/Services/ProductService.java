package com.mahitech.Buypro.Services;

import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<String> create(Product product) {
        productRepo.save(product);
        return new ResponseEntity<>("Product has been Created",HttpStatus.CREATED);

    }

    public Product getproduct(Integer id) {
        return productRepo.findByEntityId(id);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public ResponseEntity<String> delete(Integer id) {
        productRepo.deleteById(id);
        return new ResponseEntity<>("Delete Product Succesfully",HttpStatus.OK);
    }

    public List<Product> getCateogry( String sort,String filter) {
        List<Product> products = new ArrayList<>();
        
        

        List<Product> newproducts = new ArrayList<>();
        newproducts = productRepo.findAll();

        for (Product pr: newproducts) {
            if(sort.equals("category")){
                
                if(pr.getCategory().equals(filter)) {
                    products.add(pr);
                }
               
            } else if (sort.equals("price")) {
                int price = Integer.parseInt(filter);
                if(pr.getPrice()<=price){
                    products.add(pr);
                }
                
            }

        }

        return products;


    }
}
