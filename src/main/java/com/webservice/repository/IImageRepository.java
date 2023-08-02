package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Image;
import com.webservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByProduct(Product product);
}
