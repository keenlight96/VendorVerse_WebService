package com.webservice.model.dto;

import com.webservice.model.Account;
import com.webservice.model.Category;
import com.webservice.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Category category;
    private Account account;
    private Image image;
    private int sold;
    private double commission;

    public ProductDTO(int id, String name, int quantity, double price, String description, Category category, Account account) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
        this.account = account;
    }

    public ProductDTO(int id, String name, int quantity, double price, String description, Image image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
