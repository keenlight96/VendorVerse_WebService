package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
