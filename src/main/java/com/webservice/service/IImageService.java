package com.webservice.service;

import com.webservice.model.Image;
import com.webservice.model.Product;

import java.util.List;

public interface IImageService extends ICrudService<Image> {

    Image getImageByProduct(Product product);
    List<Image> getAllImageByProduct(Product product);
}
