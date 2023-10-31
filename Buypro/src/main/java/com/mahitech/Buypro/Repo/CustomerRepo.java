package com.mahitech.Buypro.Repo;

import com.mahitech.Buypro.Data.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Integer> {


    @Query(value ="SELECT customers FROM Customers customers WHERE customers.id = :id")
    Customers findByEntityId(@Param("id") Integer id);



    @Query(value ="SELECT customers FROM Customers customers WHERE customers.name = :name")
    Customers findByUsername( @Param("name")String name);
}
