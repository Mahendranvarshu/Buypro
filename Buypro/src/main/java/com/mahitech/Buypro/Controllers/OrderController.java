package com.mahitech.Buypro.Controllers;

import com.mahitech.Buypro.Data.Cart;
import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @Autowired
    CustomerController controller;

    @PostMapping("/addcart")
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Integer> requestBody) {
        Integer productid = requestBody.get("productid");

        if (productid == null) {
            return new ResponseEntity<>("Invalid productid in the request body", HttpStatus.BAD_REQUEST);
        }

        // You should retrieve the Customerid from the appropriate source.
        int Customerid = controller.nameid; // Replace with the actual Customerid retrieval logic

        orderService.addCart(Customerid, productid);

        return new ResponseEntity<>("Product added to cart", HttpStatus.CREATED);
    }

    @GetMapping("getCart")
    public List<Cart> getcard() {
        Integer id = controller.nameid;
        return orderService.getcarts(id);
    }

    @GetMapping("getcartP")
    public List<Optional<Product>> getcartpro() {
        Integer id = controller.nameid;
        return orderService.getcarProdu(id);
    }

    @DeleteMapping("/removeFromCart/{productId}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long productId) {
        // Assuming you have a method in your service to remove a product from the cart
        Integer cartId = controller.nameid; // Replace with your logic to get the cart ID
        String result = orderService.removeProductFromCart(productId.intValue(), cartId);

        if ("success".equals(result)) {
            return ResponseEntity.ok("Product removed from the cart.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to remove product from the cart.");
        }
    }
}
