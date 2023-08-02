package com.webservice.controller;

import com.webservice.model.Product;
import com.webservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "0") int page) {
        Page<Product> productPage = iProductService.getAll(PageRequest.of(page, 2));
        return new ResponseEntity<>(productPage, HttpStatus.OK);
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
}
