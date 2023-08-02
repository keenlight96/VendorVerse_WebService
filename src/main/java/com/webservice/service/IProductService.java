package com.webservice.service;

import com.webservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends ICrudService<Product> {
    Page<Product> getAll(Pageable pageable);
}
