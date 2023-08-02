package com.webservice.service.impl;

import com.webservice.model.Product;
import com.webservice.repository.IProductRepository;
import com.webservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public Product create(Product account) {
        return iProductRepository.save(account);
    }

    @Override
    public Product edit(Product account) {
        return iProductRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }
}
