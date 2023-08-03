package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query("select b from Bill b WHERE b.customer.id = :idCustomer and b.vendor.id = :idVendor and b.status.id = :idStatus")
    List<Bill> findByCustomerAndVendor(@Param("idCustomer") int idCustomer,
                                       @Param("idVendor") int idVendor, @Param("idStatus") int id);
    List<Bill> findAllByCustomerAndVendorAndStatusId(Account customer, Account vendor, int id);
    List<Bill> findAllByCustomerAndStatusId(Account customer,int idStatus);
}
