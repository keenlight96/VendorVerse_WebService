package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Bill bill;
    private int quantity;

    public BillDetail(Product product, Bill bill, int quantity) {
        this.product = product;
        this.bill = bill;
        this.quantity = quantity;
    }
}
