package com.webservice.service.impl;

import com.webservice.model.Account;
import com.webservice.repository.IAccountRepository;
import com.webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public List<Account> getAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public Account create(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public Account edit(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iAccountRepository.deleteById(id);
    }
}
