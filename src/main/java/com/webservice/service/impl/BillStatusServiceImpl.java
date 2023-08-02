package com.webservice.service.impl;

import com.webservice.model.BillStatus;
import com.webservice.repository.IBillStatusRepository;
import com.webservice.service.IBillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillStatusServiceImpl implements IBillStatusService {
    @Autowired
    IBillStatusRepository iBillStatusRepository;

    @Override
    public List<BillStatus> getAll() {
        return iBillStatusRepository.findAll();
    }

    @Override
    public BillStatus getById(int id) {
        return iBillStatusRepository.findById(id).get();
    }

    @Override
    public BillStatus create(BillStatus account) {
        return iBillStatusRepository.save(account);
    }

    @Override
    public BillStatus edit(BillStatus account) {
        return iBillStatusRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iBillStatusRepository.deleteById(id);
    }
}
