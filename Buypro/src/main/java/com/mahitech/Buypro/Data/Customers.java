package com.mahitech.Buypro.Data;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;

    private String Phone_no;
    private String address;
    private LocalDateTime createby;
    private Boolean status;
    private String password;
    private String email;


}
