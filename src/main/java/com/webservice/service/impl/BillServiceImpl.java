package com.webservice.service.impl;

import com.webservice.model.*;
import com.webservice.model.dto.BillDTO;
import com.webservice.model.dto.BillDetailDTO;
import com.webservice.repository.IBillRepository;
import com.webservice.repository.IBillRepository;
import com.webservice.repository.IBillStatusRepository;
import com.webservice.service.IBillDetailService;
import com.webservice.service.IBillService;
import com.webservice.service.IBillService;
import com.webservice.service.IBillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public List<Bill> getAll() {
        return iBillRepository.findAll();
    }

    @Override
    public Bill getById(int id) {
        return iBillRepository.findById(id).get();
    }

    @Override
    public Bill create(Bill bill) {
        return iBillRepository.save(bill);
    }

    @Override
    public Bill edit(Bill bill) {
        return iBillRepository.save(bill);
    }

    @Override
    public void deleteById(int id) {
        iBillRepository.deleteById(id);
    }

    @Override
    public List<Bill> findByCustomerAndVendor(Account customer, Account vendor, int idStatus) {
        List<Bill> bills = iBillRepository.findAllByCustomerAndVendorAndStatusId(customer, vendor, idStatus);
        return bills;
    }

    @Override
    public List<Bill> getAllByVendor(Account vendor) {
        return iBillRepository.findAllByVendor(vendor);
    }

    @Override
    public Bill acceptBill(int id) {
        Bill bill = getById(id);
        bill.setStatus(new BillStatus(3));
        return iBillRepository.save(bill);
    }

    @Override
    public Bill rejectBill(int id) {
        Bill bill = getById(id);
        bill.setStatus(new BillStatus(4));
        return iBillRepository.save(bill);
    }


}
