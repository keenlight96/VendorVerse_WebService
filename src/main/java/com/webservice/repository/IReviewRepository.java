package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProductOrderByIdDesc(Product product);
    Review findByProductIdAndCustomerId(int productId, int customerId);
}
