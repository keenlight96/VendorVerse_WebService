package com.webservice.service.impl;

import com.webservice.model.*;
import com.webservice.model.dto.BillDTO;
import com.webservice.model.dto.BillDetailDTO;
import com.webservice.repository.IBillDetailRepository;
import com.webservice.repository.IBillRepository;
import com.webservice.repository.IBillStatusRepository;
import com.webservice.repository.IProductRepository;
import com.webservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDetailServiceImpl implements IBillDetailService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;

    @Autowired
    IBillStatusService iBillStatusService;

    @Autowired
    IBillService iBillService;

    @Autowired
    IProductService iProductService;

    @Autowired
    IImageService iImageService;
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public List<BillDetail> getAll() {
        return iBillDetailRepository.findAll();
    }

    @Override
    public BillDetail getById(int id) {
        return iBillDetailRepository.findById(id).get();
    }

    @Override
    public BillDetail create(BillDetail account) {
        return iBillDetailRepository.save(account);
    }

    @Override
    public BillDetail edit(BillDetail account) {
        return iBillDetailRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iBillDetailRepository.deleteById(id);
    }

    @Override
    public BillDetail addBillDetail(BillDetail billDetail, Account account) {
        Product product = iProductService.getById(billDetail.getProduct().getId());
        Bill bill = iBillService.findByCustomerAndVendor(account, product.getAccount(), 1).get(0);
        if (bill == null) {
            Bill bill1 = iBillService.create(new Bill(product.getAccount(), account, new BillStatus(1)));
            return iBillDetailRepository.save(new BillDetail(product, bill1, billDetail.getQuantity()));
        } else {
            BillDetail billDetail1 = iBillDetailRepository.findByBillAndProduct(bill, product);
            if (billDetail1 != null) {
                billDetail1.setQuantity(billDetail1.getQuantity() + billDetail.getQuantity());
                return billDetail1;
            } else {
                return iBillDetailRepository.save(new BillDetail(product, bill, billDetail.getQuantity()));
            }
        }
    }

    @Override
    public BillDetailDTO getDtoByBillDetail(BillDetail billDetail) {
        Image image = iImageService.getImageByProduct(billDetail.getProduct());
        return new BillDetailDTO(billDetail.getId(), billDetail.getProduct(), billDetail.getBill(), billDetail.getQuantity(), image);
    }

    @Override
    public List<BillDetail> getByBill(Bill bill) {
        return iBillDetailRepository.findAllByBill(bill);
    }

    @Override
    public BillDTO getDtoByBill(Account customer, int idStatus) {
        List<Bill> bills = iBillRepository.findAllByCustomerAndStatusId(customer, idStatus);
        List<BillDetailDTO> billDetailDTOs = new ArrayList<>();

        for (int i = 0; i < bills.size(); i++) {
            List<BillDetail> billDetails = getByBill(bills.get(i));
            for (int j = 0; j < billDetails.size(); j++) {
                billDetailDTOs.add(getDtoByBillDetail(billDetails.get(j)));
            }
        }
        return new BillDTO(bills, billDetailDTOs);
    }
}
