package com.webservice.service.impl;

import com.webservice.model.Image;
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
    public Image create(Image account) {
        return iImageRepository.save(account);
    }

    @Override
    public Image edit(Image account) {
        return iImageRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iImageRepository.deleteById(id);
    }
}
