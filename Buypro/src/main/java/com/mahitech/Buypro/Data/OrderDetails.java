package com.mahitech.Buypro.Data;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="product_id")
    private Integer product_id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="cost")
    private Double cost;

    @Column(name="quantity")
    private Double quantity;

    @OneToOne
    @JoinColumn(name="product_id",referencedColumnName = "Product_ID",insertable=false, updatable = false)
    private Product product;

}
