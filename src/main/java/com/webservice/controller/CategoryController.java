package com.webservice.controller;

import com.webservice.model.Category;
import com.webservice.model.dto.ParentDTO;
import com.webservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(iCategoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(iCategoryService.create(category), HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Category> editCategory(@RequestBody Category category) {
        return new ResponseEntity<>(iCategoryService.edit(category), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public void deleteCategory(@RequestBody Category category) {
        iCategoryService.deleteById(category.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
        return new ResponseEntity<>(iCategoryService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/listParenDTO")
    public ResponseEntity<List<ParentDTO>> getAllParentDTO() {
        return new ResponseEntity<>(iCategoryService.getAllParentDTO(), HttpStatus.OK);
    }
}
