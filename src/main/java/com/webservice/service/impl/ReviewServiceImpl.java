package com.webservice.service.impl;

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
    public Review create(Review account) {
        return iReviewRepository.save(account);
    }

    @Override
    public Review edit(Review account) {
        return iReviewRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iReviewRepository.deleteById(id);
    }
}
