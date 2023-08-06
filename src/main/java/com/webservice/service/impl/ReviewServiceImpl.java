package com.webservice.service.impl;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.Review;
import com.webservice.repository.IReviewRepository;
import com.webservice.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    IReviewRepository iReviewRepository;

    @Override
    public List<Review> getAll() {
        return iReviewRepository.findAll();
    }

    @Override
    public Review getById(int id) {
        return iReviewRepository.findById(id).get();
    }

    @Override
    public Review create(Review review) {
        return iReviewRepository.save(review);
    }

    @Override
    public Review edit(Review review) {
        return iReviewRepository.save(review);
    }

    @Override
    public void deleteById(int id) {
        iReviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getAllByProduct(Product product) {
        return iReviewRepository.findAllByProductOrderByIdDesc(product);
    }

    @Override
    public void save(Account customer, Review review) {
        review.setCustomer(customer);
        iReviewRepository.save(review);
    }

    @Override
    public Review getByProductAndCustomer(int productId, int customerId) {
        return iReviewRepository.findByProductIdAndCustomerId(productId,customerId);
    }
}
