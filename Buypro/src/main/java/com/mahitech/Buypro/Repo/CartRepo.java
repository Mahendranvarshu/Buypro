package com.mahitech.Buypro.Repo;

import com.mahitech.Buypro.Data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {



    @Query(value = "SELECT cart FROM Cart cart WHERE cart.customer_id = :customer_id")
    List<Cart> findBycustomerId(Integer customer_id);
}
