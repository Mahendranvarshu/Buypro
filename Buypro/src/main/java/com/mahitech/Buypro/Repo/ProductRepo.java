package com.mahitech.Buypro.Repo;

import com.mahitech.Buypro.Data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "select product from Product product where product.product_ID = :id")
    Product findByEntityId( Integer id);



    @Query(value = "SELECT * FROM product WHERE product_ID = :productID", nativeQuery = true)
    Product findByProduct_ID(Integer productID);
}
