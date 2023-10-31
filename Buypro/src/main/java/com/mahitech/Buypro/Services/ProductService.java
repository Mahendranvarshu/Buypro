package com.mahitech.Buypro.Services;

import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Transactional
    public ResponseEntity<String> create(Product product, MultipartFile file) {
        try {
            // Save the product information (excluding the image) to the database
            Product savedProduct = productRepo.save(product);

            // Associate the image with the product
            savedProduct.setImage(file.getBytes());

            // Update the product to include the image
            productRepo.save(savedProduct);

            return ResponseEntity.ok("Product created successfully with image.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product creation failed: " + e.getMessage());
        }
    }

    public Product getProductById(Integer productID) {
        return productRepo.findByProduct_ID(productID);
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

    public List<Product> getcartproducts(Integer productID) {

        return productRepo.findAll();
    }
}
