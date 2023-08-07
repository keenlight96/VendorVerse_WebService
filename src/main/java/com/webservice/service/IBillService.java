package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.model.dto.BillDTO;

import java.util.List;

public interface IBillService extends ICrudService<Bill> {
    List<Bill> getAllByCustomer(Account customer);
    List<Bill> findByCustomerAndVendor(Account customer, Account vendor, int idStatus);
    List<Bill> getAllByVendor(Account vendor);
    Bill acceptBill(int id);
    Bill rejectBill(int id);
    List<Bill> getBillCustomerByStatus(Account customer,int statusId);

}
