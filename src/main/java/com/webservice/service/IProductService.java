package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Product;
import com.webservice.model.dto.ProductDTO;
import com.webservice.model.dto.ProductDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends ICrudService<Product> {
    Page<Product> getAll(Pageable pageable);
    Page<ProductDTO> getAllDTOByCurrentVendor(Pageable pageable, Account account);
    ProductDTO convertToProductDTO(Product product);
    ProductDetailDTO getProductDetail(int productId);
}
