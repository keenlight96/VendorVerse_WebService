package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double price;
    @Lob
    private String description;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;

}
