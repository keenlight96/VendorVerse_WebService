package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.Review;

import java.util.List;

public interface IReviewService extends ICrudService<Review> {
    List<Review> getAllByProduct(Product product);
    void save(Account customer, Review review);
    Review getByProductAndCustomer(int productId, int customerId);
}
