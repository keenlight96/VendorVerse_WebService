package com.webservice.service.impl;

import com.webservice.model.Bill;
import com.webservice.repository.IBillRepository;
import com.webservice.repository.IBillRepository;
import com.webservice.service.IBillService;
import com.webservice.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService{
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
    public Bill create(Bill account) {
        return iBillRepository.save(account);
    }

    @Override
    public Bill edit(Bill account) {
        return iBillRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iBillRepository.deleteById(id);
    }
}
