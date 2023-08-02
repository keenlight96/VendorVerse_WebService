package com.webservice.service;

import com.webservice.model.Image;
import com.webservice.model.Product;

public interface IImageService extends ICrudService<Image> {

    Image getImageByProduct(Product product);
}
