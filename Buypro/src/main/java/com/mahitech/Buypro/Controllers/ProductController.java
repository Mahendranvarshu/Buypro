package com.mahitech.Buypro.Controllers;


import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("getproduct/{id}")
    public Product getproduct(@PathVariable Integer id){
        return productService.getproduct(id);
    }
    @GetMapping("getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>  delete(@PathVariable Integer id){
        return productService.delete(id);
    }

    @GetMapping("get/{Sort}/{category}")
    public List<Product> getCategory( @PathVariable  String Sort, @PathVariable String category){
        return productService.getCateogry(Sort,category);
    }

}
