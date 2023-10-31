package com.mahitech.Buypro.Controllers;


import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Repo.ProductRepo;
import com.mahitech.Buypro.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("Product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestPart("file") MultipartFile file, @RequestPart("product") Product product) {
        // Handle your file and product data
        // Make sure to configure Spring to handle multipart requests properly
        return productService.create(product, file);
    }



    @GetMapping("/{productID}")
    public List<Product> getProductById(@PathVariable Integer productID) {
        return  productService.getcartproducts(productID);
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

//    @GetMapping("getproduct/{id}")
//    public ResponseEntity<Resource> retrieve(@PathVariable String filename) {
//        var image = imageService.getImage(filename);
//        var body = new ByteArrayResource(image.getData());
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_TYPE, image.getMimeType())
//                .cacheControl(CacheControl.maxAge(Duration.ofSeconds(60)).cachePrivate().mustRevalidate())
//                .body(body);
//    }
//






}
