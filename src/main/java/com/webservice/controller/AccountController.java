package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return new ResponseEntity<>(iAccountService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.create(account), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Account> editAccount(@RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.edit(account), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteAccount(@RequestBody Account account) {
        iAccountService.deleteById(account.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable int id) {
        return new ResponseEntity<>(iAccountService.getById(id), HttpStatus.OK);
    }
}
