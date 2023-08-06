package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.dto.AccountToken;
import com.webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @PostMapping("/current")
    public AccountToken getCurrentAccount(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = iAccountService.getAccountByUsername(userDetails.getUsername());
        AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), token, account.getAvatar(), account.getRole());
        return accountToken;
    }

    @PostMapping("/receivers/{id}")
    public ResponseEntity<List<AccountToken>> getReceiversOfAccountId(@PathVariable int id) {
        List<AccountToken> accountTokens = new ArrayList<>();
        List<Account> accounts = iAccountService.getReceiversOfAccountId(id);
        for (Account account :
                accounts) {
            accountTokens.add(new AccountToken(account.getId(),account.getUsername(),"", account.getAvatar(), account.getRole()));
        }
        System.out.println(accountTokens.size());
        return new ResponseEntity<>(accountTokens, HttpStatus.OK);
    }

    @GetMapping("/receiver/{id}")
    public ResponseEntity<AccountToken> findAccountTokenById(@PathVariable int id) {
        Account account = iAccountService.getById(id);
        AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), "", account.getAvatar(), account.getRole());
        return new ResponseEntity<>(accountToken, HttpStatus.OK);
    }
}
