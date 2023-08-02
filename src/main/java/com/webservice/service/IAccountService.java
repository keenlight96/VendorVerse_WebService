package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> getAll();
    Account getById(int id);
    Account create(Account account);
    Account edit(Account account);
    void deleteById (int id);
    Account checkRegister(Account account);

    Account getAccountLogin(String username, String password);
}
