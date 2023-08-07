package com.webservice.service.impl;

import com.webservice.model.Image;
import com.webservice.model.Product;
import com.webservice.repository.IImageRepository;
import com.webservice.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    IImageRepository iImageRepository;

    @Override
    public List<Image> getAll() {
        return iImageRepository.findAll();
    }

    @Override
    public Image getById(int id) {
        return iImageRepository.findById(id).get();
    }

    @Override
    public Image create(Image image) {
        return iImageRepository.save(image);
    }

    @Override
    public Image edit(Image image) {
        return iImageRepository.save(image);
    }

    @Override
    public void deleteById(int id) {
        iImageRepository.deleteById(id);
    }

    @Override
    public Image getImageByProduct(Product product) {
        List<Image> images = iImageRepository.findByProduct(product);
        if (images.isEmpty())
            return null;
        else
            return images.get(0);
    }

    @Override
    public List<Image> getAllImageByProduct(Product product) {
        return iImageRepository.findByProduct(product);
    }
}
