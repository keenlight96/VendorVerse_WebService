package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillStatusRepository extends JpaRepository<BillStatus, Integer> {
}
