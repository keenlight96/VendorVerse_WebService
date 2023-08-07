package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Review;
import com.webservice.service.IAccountService;
import com.webservice.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    IReviewService iReviewService;
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public ResponseEntity<List<Review>> getAll() {
        return new ResponseEntity<>(iReviewService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account customer = iAccountService.getAccountByUsername(userDetails.getUsername());
        iReviewService.save(customer,review);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Review> editReview(@RequestBody Review review) {
        return new ResponseEntity<>(iReviewService.edit(review), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteReview(@RequestBody Review review) {
        iReviewService.deleteById(review.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable int id) {
        return new ResponseEntity<>(iReviewService.getById(id), HttpStatus.OK);
    }
}
