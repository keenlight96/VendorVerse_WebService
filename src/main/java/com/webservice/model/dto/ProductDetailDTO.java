package com.webservice.model.dto;

import com.webservice.model.Account;
import com.webservice.model.Category;
import com.webservice.model.Image;
import com.webservice.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ProductDetailDTO {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Category category;
    private Account account;
    private int sold;
    private List<Image> images;
    private List<Review> reviews;
    private double avgRating;

}
