package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.service.IAccountService;
import com.webservice.service.IBillDetailService;
import com.webservice.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bill")
public class BillController {
    @Autowired
    IBillService iBillService;
//    @Autowired
//    IAccountService iAccountService;

    @Autowired
    IBillDetailService iBillDetailService;

    @GetMapping
    public ResponseEntity<List<Bill>> getAll() {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Account account = iAccountService.getAccountByUsername(userDetails.getUsername());
        return new ResponseEntity<>(iBillService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(iBillService.create(bill), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Bill> editBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(iBillService.edit(bill), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBill(@RequestBody Bill bill) {
        iBillService.deleteById(bill.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findBillById(@PathVariable int id) {
        return new ResponseEntity<>(iBillService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/payTheBill")
    public ResponseEntity<?> payTheBill(@RequestParam int idBill) {
        if (iBillDetailService.payTheBill(idBill) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
