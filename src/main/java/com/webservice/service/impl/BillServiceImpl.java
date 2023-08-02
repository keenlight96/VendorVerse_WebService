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
    @Autowired
    IBillDetailService iBillDetailService;

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
        return iBillRepository.findByCustomerAndVendor(customer, vendor, idStatus);
    }

    @Override
    public BillDTO getDtoByBill(Account customer, int idStatus) {
        List<Bill> bills = iBillRepository.findAllByCustomerAndStatusId(customer, idStatus);
        List<BillDetailDTO> billDetailDTOs = new ArrayList<>();

        for (int i = 0; i < bills.size(); i++) {
            List<BillDetail> billDetails = iBillDetailService.getByBill(bills.get(i));
            for (int j = 0; j < billDetails.size(); j++) {
                billDetailDTOs.add(iBillDetailService.getDtoByBillDetail(billDetails.get(j)));
            }
        }
        return new BillDTO(bills, billDetailDTOs);
    }
}
