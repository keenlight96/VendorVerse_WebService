package com.webservice.repository;

import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail, Integer> {
    BillDetail findByBillAndProduct(Bill bill, Product product);

    List<BillDetail> findAllByBill(Bill bill);

    void deleteById(int idBillDetail);
    @Modifying
    @Query("update BillDetail bd set bd.quantity = :quantity WHERE bd.id = :id")
    void updateQuantity(@Param("quantity") int quantity,@Param("id") int id);

}
