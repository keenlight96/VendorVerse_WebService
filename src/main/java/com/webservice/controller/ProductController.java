package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.dto.ProductDTO;
import com.webservice.service.IAccountService;
import com.webservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "0") int page) {
        Page<Product> productPage = iProductService.getAll(PageRequest.of(page, 2));
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/vendor")
    public ResponseEntity<Page<ProductDTO>> getAllDTOByVendor(@RequestParam(defaultValue = "0") int page) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = iAccountService.getAccountByUsername(userDetails.getUsername());
        Page<ProductDTO> productDTOPage = iProductService.getAllDTOByCurrentVendor(PageRequest.of(page, 100), account);
        return new ResponseEntity<>(productDTOPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.create(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.edit(product), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        iProductService.deleteById(product.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) {
        return new ResponseEntity<>(iProductService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/vendor")
    public ResponseEntity<Product> createProductOfVendor(@RequestBody Product product) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = iAccountService.getAccountByUsername(userDetails.getUsername());
        product.setAccount(account);
        return new ResponseEntity<>(iProductService.create(product), HttpStatus.OK);
    }
}
