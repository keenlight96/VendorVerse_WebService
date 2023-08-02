package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail, Integer> {
}
