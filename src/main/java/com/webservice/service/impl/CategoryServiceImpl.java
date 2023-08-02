package com.webservice.service.impl;

import com.webservice.model.Category;
import com.webservice.repository.ICategoryRepository;
import com.webservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public Category create(Category account) {
        return iCategoryRepository.save(account);
    }

    @Override
    public Category edit(Category account) {
        return iCategoryRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iCategoryRepository.deleteById(id);
    }
}
