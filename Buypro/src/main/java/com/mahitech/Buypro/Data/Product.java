package com.mahitech.Buypro.Data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    private Integer product_ID;

    @Column(name = "Product_name")
    private String product_name;

    @Column(name = "Brand_name")
    private String brand_name;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Category")
    private String category;

    @Column(name = "Stack")
    private Integer stack ;

    @Column(name = "Warenty")
    private Integer warenty;

    @Column(name = "Offer_End_Date")
    private String offerEnd_date;

    @Lob
    @Column(name = "Product_img")
    private byte[] image;


}
