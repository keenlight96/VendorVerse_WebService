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
import java.util.Date;
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
        List<Bill> bills = iBillService.findByCustomerAndVendor(account, product.getAccount(), 1);
        Bill bill;
        if (bills.isEmpty()) {
            bill = null;
        } else {
            bill = bills.get(0);
        }
        if (bill == null) {
            Bill bill1 = iBillService.create(new Bill(product.getAccount(), account, new BillStatus(1)));
            return iBillDetailRepository.save(new BillDetail(product, bill1, billDetail.getQuantity()));
        } else {
            BillDetail billDetail1 = iBillDetailRepository.findByBillAndProduct(bill, product);
            if (billDetail1 != null) {
                billDetail1.setQuantity(billDetail1.getQuantity() + billDetail.getQuantity());
                return iBillDetailRepository.save(billDetail1);
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

    @Override
    public void updateQuantity(int quantity, int id) {
        iBillDetailRepository.updateQuantity(quantity, id);
    }

    @Override
    public Bill payTheBill(int idBill) {
        Bill bill = iBillService.getById(idBill);
        List<BillDetail> billDetails = iBillDetailRepository.findAllByBill(bill);
        boolean check = false;
        for (BillDetail bdt : billDetails) {
            Product product = iProductService.getById(bdt.getProduct().getId());
            if (product.getQuantity() >= bdt.getQuantity()) {
                check = true;
            } else {
                check = false;
            }
        }
        if (check) {
            bill.setDate(new Date());
            BillStatus billStatus = iBillStatusService.getById(2);
            bill.setStatus(billStatus);
            for (BillDetail bdt : billDetails) {
                Product product = iProductService.getById(bdt.getProduct().getId());
                product.setQuantity(product.getQuantity() - bdt.getQuantity());
                iProductService.create(product);
            }
            return iBillRepository.save(bill);
        } else return null;
    }

    @Override
    public List<BillDetailDTO> getBillDetailDtoByBill(Bill bill) {
        List<BillDetailDTO> billDetailDTOs = new ArrayList<>();
        List<BillDetail> billDetails = getByBill(bill);
        for (BillDetail b : billDetails) {
            billDetailDTOs.add(getDtoByBillDetail(b));
        }
        return billDetailDTOs;
    }

    @Override
    public BillDetail findByBillAndProductId(Bill bill, int productId) {
        return iBillDetailRepository.findByBillAndProductId(bill, productId);
    }
}
