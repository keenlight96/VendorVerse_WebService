package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double total;
    @ManyToOne
    private Account vendor;
    @ManyToOne
    private Account customer;
    @ManyToOne
    private BillStatus status;

    public Bill(Account vendor, Account customer, BillStatus status) {
        this.vendor = vendor;
        this.customer = customer;
        this.status = status;
    }
}
