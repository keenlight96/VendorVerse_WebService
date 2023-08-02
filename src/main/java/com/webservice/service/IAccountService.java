package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IAccountService extends ICrudService<Account> {
  Account getAccountByUsername(String username);
}
