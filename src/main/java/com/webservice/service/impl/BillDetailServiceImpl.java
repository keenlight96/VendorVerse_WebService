package com.webservice.service.impl;

import com.webservice.model.BillDetail;
import com.webservice.repository.IBillDetailRepository;
import com.webservice.service.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailServiceImpl implements IBillDetailService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;

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
}
