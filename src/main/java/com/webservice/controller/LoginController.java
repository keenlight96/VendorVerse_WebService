package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.dto.AccountToken;
import com.webservice.service.IAccountService;
import com.webservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    IAccountService accountService;


    @PostMapping("/login")
    public AccountToken getLogin(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        account = accountService.getAccountLogin(account.getUsername(), account.getPassword());
        String token = jwtService.createToken(authentication);
        AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), token, account.getAvatar(), account.getRole());
        return accountToken;
    }


}
