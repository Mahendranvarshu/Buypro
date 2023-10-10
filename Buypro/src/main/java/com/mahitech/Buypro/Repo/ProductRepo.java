package com.mahitech.Buypro.Repo;

import com.mahitech.Buypro.Data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "select product from Product product where product.product_ID = :product_ID")
    Product findByEntityId(@Param("product_ID") Integer id);
}
