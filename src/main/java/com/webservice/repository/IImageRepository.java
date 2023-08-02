package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Image, Integer> {
}
