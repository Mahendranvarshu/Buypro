package com.mahitech.Buypro.Data;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer OrderID;


    @Column(name = "Customer_ID")
    private  Integer customerid;

    @OneToOne
    @JoinColumn(name = "Customer_ID",referencedColumnName = "id" ,insertable = false,updatable = false )
    private Customers customer;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER  )
    private List<OrderDetails> listOfProduct;




    @Column(name = "Quentity")
    private Integer quantity;


    @Column(name = "Order_Date")
    private LocalDateTime order_date;


    @Column(name = "Cost")
    private Double cost;
}
