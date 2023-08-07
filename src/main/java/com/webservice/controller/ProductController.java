package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.Product;
import com.webservice.model.dto.ProductDTO;
import com.webservice.model.dto.ProductDetailDTO;
import com.webservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IBillService iBillService;
    @Autowired
    IBillDetailService iBillDetailService;
    @Autowired
    IReviewService iReviewService;

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

    @PostMapping("/shop/{vendorId}")
    public ResponseEntity<Page<ProductDTO>> getProductDTOByVendor(@RequestParam(defaultValue = "0") int page,@PathVariable int vendorId){
        Account account = iAccountService.getById(vendorId);
        Page<ProductDTO> productDTOPage = iProductService.getAllDTOByCurrentVendor(PageRequest.of(page, 18), account);
        return new ResponseEntity<>(productDTOPage, HttpStatus.OK);
    }

    @PostMapping("/shop")
    public ResponseEntity<Page<ProductDTO>> getAllDTO(@RequestParam(defaultValue = "0") int page) {
        Page<ProductDTO> products = iProductService.getAllProductDTO(PageRequest.of(page, 4));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping("/searchByProductName")
    public ResponseEntity<Page<ProductDTO>> getProductDTOByLikeName(@RequestParam(defaultValue = "0") int page, @RequestParam String name) {
       Page<ProductDTO> productDTOPage = iProductService.getAllByNameLike(name,PageRequest.of(page, 18));
        return new ResponseEntity<>(productDTOPage, HttpStatus.OK);
    }

    @PostMapping("/productDetail")
    public ResponseEntity<ProductDetailDTO> getProductDetail(@RequestParam int productId) {
        return new ResponseEntity<>(iProductService.getProductDetail(productId), HttpStatus.OK);
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

    @PostMapping("/checkReview")
    public boolean checkReview(@RequestParam int productId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account customer = iAccountService.getAccountByUsername(userDetails.getUsername());
        if (iReviewService.getByProductAndCustomer(productId, customer.getId()) == null) {
            List<Bill> bills = iBillService.getBillCustomerByStatus(customer, 3);
            if (bills.isEmpty()) {
                return true;
            }
            for (Bill b : bills) {
                if (iBillDetailService.findByBillAndProductId(b, productId) != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
