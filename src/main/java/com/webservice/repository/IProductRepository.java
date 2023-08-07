package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findAllByAccount(Account account);
    Page<Product> findAllByAccount(Pageable pageable, Account account);
    @Query("select p from Product p WHERE p.name like :name")
    Page<Product> findAllByNameLike(@Param("name") String name,Pageable pageable);
}
