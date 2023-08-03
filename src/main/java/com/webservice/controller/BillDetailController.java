package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.dto.BillDTO;
import com.webservice.model.dto.BillDetailDTO;
import com.webservice.service.IAccountService;
import com.webservice.service.IBillDetailService;
import com.webservice.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/billDetail")
public class BillDetailController {

    @Autowired
    IBillDetailService iBillDetailService;
    @Autowired
    IAccountService iAccountService;

    @PostMapping("/addBillDetail")
    public ResponseEntity<?> addBillDetail(@RequestBody BillDetail billDetail) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account customer = iAccountService.getAccountByUsername(userDetails.getUsername());
        return new ResponseEntity<>(iBillDetailService.addBillDetail(billDetail, customer), HttpStatus.OK);
    }


    @PostMapping("/byStatus")
    public ResponseEntity<BillDTO> getAllBillDetail(@RequestParam int idStatus) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account customer = iAccountService.getAccountByUsername(userDetails.getUsername());
        return new ResponseEntity<>(iBillDetailService.getDtoByBill(customer, idStatus), HttpStatus.OK);
    }

    @PostMapping("/deleteProductByCart")
    public ResponseEntity<?> deleteProductByCart(@RequestParam int idBillDetail) {
        iBillDetailService.deleteById(idBillDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getByBill")
    public List<BillDetailDTO> getByBill(@RequestBody Bill bill) {
        return iBillDetailService.getBillDetailDtoByBill(bill);
    }

    @PostMapping("/updateQuantityBillDetail")
    public void updateQuantityBillDetail(@RequestBody BillDetailDTO billDetailDTO) {
        iBillDetailService.updateQuantity(billDetailDTO.getQuantity(), billDetailDTO.getId());
    }

    @PostMapping
    public ResponseEntity<BillDetail> createBillDetail(@RequestBody BillDetail billDetail) {
        return new ResponseEntity<>(iBillDetailService.create(billDetail), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BillDetail> editBillDetail(@RequestBody BillDetail billDetail) {
        return new ResponseEntity<>(iBillDetailService.edit(billDetail), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBillDetail(@RequestBody BillDetail billDetail) {
        iBillDetailService.deleteById(billDetail.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDetail> findBillDetailById(@PathVariable int id) {
        return new ResponseEntity<>(iBillDetailService.getById(id), HttpStatus.OK);
    }
}
