package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Account customer;
    private int rating;
    private String content;
}
