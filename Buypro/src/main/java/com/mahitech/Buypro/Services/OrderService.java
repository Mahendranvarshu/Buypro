package com.mahitech.Buypro.Services;

import com.mahitech.Buypro.Data.Cart;
import com.mahitech.Buypro.Data.Product;
import com.mahitech.Buypro.Repo.CartRepo;
import com.mahitech.Buypro.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    CartRepo cartRepo;


    @Autowired
    ProductRepo productRepo;

    public void addCart(int customerid, int product) {
        Cart cart = new Cart();
        cart.setCustomer_id(customerid);
        cart.setProduct(product);
        cartRepo.save(cart);
    }



    public List<Cart> getcarts(Integer id) {
        return cartRepo.findBycustomerId(id);
    }

    public List<Optional<Product>> getcarProdu(Integer id) {

        List<Optional<Product>> products = new ArrayList<>();
        List<Cart> carts = cartRepo.findBycustomerId(id);

        for (Cart cart: carts) {
            Optional<Product> product = productRepo.findById(cart.getProduct());
            products.add(product);


        }
        return products;
    }



    public String removeProductFromCart(Integer productId, Integer cartId) {
        List<Cart> carts = cartRepo.findBycustomerId(cartId);
        for (Cart c:carts  ) {
            if(c.getProduct().equals(productId)){

              cartRepo.deleteById(c.getId());
              return "success";

            }

        }
        return "notsuccess";

    }
}
