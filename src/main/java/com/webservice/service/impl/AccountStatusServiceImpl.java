package com.webservice.service.impl;

import com.webservice.model.AccountStatus;
import com.webservice.repository.IAccountStatusRepository;
import com.webservice.service.IAccountStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatusServiceImpl implements IAccountStatusService {
    @Autowired
    IAccountStatusRepository iAccountStatusRepository;

    @Override
    public List<AccountStatus> getAll() {
        return iAccountStatusRepository.findAll();
    }

    @Override
    public AccountStatus getById(int id) {
        return iAccountStatusRepository.findById(id).get();
    }

    @Override
    public AccountStatus create(AccountStatus account) {
        return iAccountStatusRepository.save(account);
    }

    @Override
    public AccountStatus edit(AccountStatus account) {
        return iAccountStatusRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iAccountStatusRepository.deleteById(id);
    }
}
