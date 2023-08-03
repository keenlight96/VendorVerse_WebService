package com.webservice.controller;

import com.webservice.model.AccountStatus;
import com.webservice.service.IAccountStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accountStatus")
public class AccountStatusController {
    @Autowired
    IAccountStatusService iAccountStatusService;

    @GetMapping
    public ResponseEntity<List<AccountStatus>> getAll() {
        return new ResponseEntity<>(iAccountStatusService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountStatus> createAccountStatus(@RequestBody AccountStatus accountStatus) {
        return new ResponseEntity<>(iAccountStatusService.create(accountStatus), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AccountStatus> editAccountStatus(@RequestBody AccountStatus accountStatus) {
        return new ResponseEntity<>(iAccountStatusService.edit(accountStatus), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteAccountStatus(@RequestBody AccountStatus accountStatus) {
        iAccountStatusService.deleteById(accountStatus.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStatus> findAccountStatusById(@PathVariable int id) {
        return new ResponseEntity<>(iAccountStatusService.getById(id), HttpStatus.OK);
    }
}
