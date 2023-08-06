package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findAllByAccount(Account account);
    Page<Product> findAllByAccount(Pageable pageable, Account account);
}
