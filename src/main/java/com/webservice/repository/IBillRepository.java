package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
}
