package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    IAccountService accountService;
    @PostMapping
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account) {
        if (accountService.checkRegister(account) == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
