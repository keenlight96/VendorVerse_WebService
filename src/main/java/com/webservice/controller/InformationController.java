package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/updateInfo")
public class InformationController {
    @Autowired
    IAccountService accountService;

    @PostMapping("/{id}")
    public ResponseEntity<Account> updateInformation(@PathVariable int id, @RequestBody Account account) {
        account.setId(id);
        accountService.edit(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("/editAccount")
    public ResponseEntity<Account> editAccount(@RequestBody Account account){
        Account account1 = accountService.getById(account.getId());
        if(!account.getPassword().equals(""))
            account1.setPassword(account.getPassword());
        account1.setPhoneNumber(account.getPhoneNumber());
        account1.setAvatar(account.getAvatar());
        account1.setBirthday(account.getBirthday());
        accountService.edit(account1);
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }
}
