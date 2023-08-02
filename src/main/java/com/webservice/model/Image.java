package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    @ManyToOne
    private Product product;
}
