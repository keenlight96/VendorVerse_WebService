package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
