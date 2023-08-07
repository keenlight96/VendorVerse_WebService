package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends ICrudService<Product> {
    Page<Product> getAll(Pageable pageable);
    Page<ProductDTO> getAllProductDTO(Pageable pageable);
    Page<ProductDTO> getAllDTOByCurrentVendor(Pageable pageable, Account account);
    ProductDTO convertToProductDTO(Product product);
}
