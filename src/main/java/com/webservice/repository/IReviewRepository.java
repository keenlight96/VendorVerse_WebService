package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
}
