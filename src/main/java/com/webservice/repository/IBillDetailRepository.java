package com.webservice.repository;

import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail, Integer> {
    BillDetail findByBillAndProduct(Bill bill, Product product);

    List<BillDetail> findAllByBill(Bill bill);

    Integer countBillDetailByProduct(Product product);
}
