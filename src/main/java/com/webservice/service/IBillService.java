package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.model.dto.BillDTO;

import java.util.List;

public interface IBillService extends ICrudService<Bill> {
    List<Bill> findByCustomerAndVendor(Account customer, Account vendor, int idStatus);

}
