package com.webservice.service.impl;

import com.webservice.model.Account;
import com.webservice.model.Image;
import com.webservice.model.Product;
import com.webservice.model.Review;
import com.webservice.model.dto.ProductDTO;
import com.webservice.model.dto.ProductDetailDTO;
import com.webservice.repository.IBillDetailRepository;
import com.webservice.repository.IProductRepository;
import com.webservice.service.IImageService;
import com.webservice.service.IProductService;
import com.webservice.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IBillDetailRepository iBillDetailRepository;
    @Autowired
    IImageService iImageService;
    @Autowired
    IReviewService iReviewService;


    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return iProductRepository.findById(id);
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

    @Override
    public Page<ProductDTO> getAllDTOByCurrentVendor(Pageable pageable, Account account) {
        Page<Product> productPage = iProductRepository.findAllByAccount(pageable, account);
        Page<ProductDTO> productDTOPage = productPage.map(this::convertToProductDTO);
        return productDTOPage;
    }

    @Override
    public ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getQuantity(),
                product.getPrice(), product.getDescription(),product.getCategory(),product.getAccount());
        productDTO.setImage(iImageService.getImageByProduct(product));
        productDTO.setSold(iBillDetailRepository.countBillDetailByProduct(product));
        productDTO.setCommission(productDTO.getPrice() * productDTO.getSold());
        return productDTO;
    }

    @Override
    public ProductDetailDTO getProductDetail(int productId) {
        Product product = iProductRepository.findById(productId);
        List<Image> images = iImageService.getAllImageByProduct(product);
        List<Review> reviews = iReviewService.getAllByProduct(product);
        int sold = iBillDetailRepository.countBillDetailByProduct(product);
        double totalRating = 0;
        for (Review rv: reviews) {
            totalRating += rv.getRating();
        }
        double avgRating = totalRating/reviews.size();
        ProductDetailDTO productDetailDTO = new ProductDetailDTO(product.getId(),product.getName(),
                product.getQuantity(), product.getPrice(),product.getDescription(),
                product.getCategory(),product.getAccount(),sold, images,reviews,avgRating);

        return productDetailDTO;
    }
    @Override
    public Page<ProductDTO> getAllByNameLike(String name, Pageable pageable) {
        Page<Product> productPage = iProductRepository.findAllByNameLike('%' + name + '%',pageable);
        Page<ProductDTO> productDTOPage = productPage.map(this::convertToProductDTO);
        return productDTOPage;
    }
}
