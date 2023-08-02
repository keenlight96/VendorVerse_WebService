package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.Product;
import com.webservice.model.dto.BillDetailDTO;

import java.util.List;

public interface IBillDetailService extends ICrudService<BillDetail> {
    BillDetail addBillDetail(BillDetail billDetail,Account account);
    BillDetailDTO getDtoByBillDetail(BillDetail billDetail);
    List<BillDetail> getByBill(Bill bill);
}
